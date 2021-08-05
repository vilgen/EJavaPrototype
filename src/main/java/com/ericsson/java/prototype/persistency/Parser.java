package com.ericsson.java.prototype.persistency;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import com.ericsson.java.prototype.model.Subscriber;
import com.ericsson.java.prototype.model.SubscriberJson;

public class Parser {
		
	public static String parseDataFilePath(String Data) {
		String path = "";
		
		int indexOfFirstPattern = Data.indexOf("={");
		int indexOfLastPattern = Data.indexOf("}");
		
		path = Data.substring(indexOfFirstPattern+2, indexOfLastPattern);
		
		return path;
	}
	
	public static String parseCronExpression(String Data) {
		String cron_expression = "";
		
		int indexOfFirstPattern = Data.lastIndexOf("={");
		int indexOfLastPattern = Data.lastIndexOf("}");
		
		cron_expression = Data.substring(indexOfFirstPattern+2, indexOfLastPattern);
		
		return cron_expression;
	}
	
	public static String parseDataFilePathApp(String Data) {
		String path = "";
		
		int indexOfFirstPattern = Data.indexOf("=");
		int indexOfLastPattern = Data.indexOf("cron.expression");
		
		path = Data.substring(indexOfFirstPattern+1, indexOfLastPattern).trim().replace("\\n", "").replace("\\r", "");
		
		return path;
	}
	
	public static String parseCronExpressionApp(String Data) {
		String cron_expression = "";
		
		int indexOfFirstPattern = Data.lastIndexOf("=");
		//int indexOfLastPattern = Data.lastIndexOf("}");
		
		cron_expression = Data.substring(indexOfFirstPattern+1);
		
		return cron_expression;
	}
	
	public static SubscriberJson parseDataJson(String Data) {
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();		
		SubscriberJson sj = gson.fromJson(Data, SubscriberJson.class);
		
		return sj;
		
	}
	
	public static String parseDataJson(List<Subscriber> subs) {
		
		SubscriberJson sj = new SubscriberJson();
		sj.setSubscribers(subs);
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.setPrettyPrinting().create();		
		String jsonString = gson.toJson(sj);
		
		return jsonString;
		
	}
}

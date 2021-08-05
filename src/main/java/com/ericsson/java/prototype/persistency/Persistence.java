package com.ericsson.java.prototype.persistency;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.java.prototype.io.ReadFile;
import com.ericsson.java.prototype.io.WriteFile;
import com.ericsson.java.prototype.model.Subscriber;
import com.ericsson.java.prototype.model.SubscriberJson;
import com.ericsson.java.prototype.rest.services.SubscriberController;

public class Persistence {

	private static final Logger log = LoggerFactory.getLogger(SubscriberController.class);

	private String data_file_path;
	private String scheduler;

	public String getData_file_path() {
		return data_file_path;
	}

	public void setData_file_path(String data_file_path) {
		this.data_file_path = data_file_path;
	}

	public String getScheduler() {
		return scheduler;
	}

	public void setScheduler(String scheduler) {
		this.scheduler = scheduler;
	}

	public List<Subscriber> Init() {

		ReadFile fr = new ReadFile();
		fr.readConfFile();

		/* Pass app.conf file content to file path parser to obtain data file path */
		data_file_path = Parser.parseDataFilePath(fr.getApp_conf_content());

		/* Pass app.conf file content to scheduler parser to obtain cron expression */
		scheduler = Parser.parseCronExpression(fr.getApp_conf_content());

		/* Write app.conf values to app.properties */
		WriteFile fw = new WriteFile();
		fw.writeAppConfDataToLocale(data_file_path, scheduler);

		/* Read data_file_path from app.properties */
		String app_prop_file_content = fr.readAppPropFile();

		/* Get data.json path from app.properties */
		String new_data_file_path = Parser.parseDataFilePathApp(app_prop_file_content);

		/* Read data.json content and return it */
		String jsonStr = fr.readDataFile(new_data_file_path);

		/* Convert data.json to json object */
		SubscriberJson subJson = Parser.parseDataJson(jsonStr);

		/* convert json objects to subscribers list */
		List<Subscriber> subscribers = new ArrayList<>();

		try {
			subscribers = subJson.getSubscribers();
		} catch (NullPointerException e) {
			log.info("No data exists in data.json file!");
			e.printStackTrace();
		}

		return subscribers;
	}

}

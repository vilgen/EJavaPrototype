package com.ericsson.java.prototype.services;

public class ServiceResponse {
	
	private int respId;
	private String respMessage;
	
	public ServiceResponse() {}
	

	public ServiceResponse(int Id, String Message) {
		this.respId = Id;
		this.respMessage = Message;
	}


	public int getRespId() {
		return respId;
	}


	public void setRespId(int respId) {
		this.respId = respId;
	}


	public String getRespMessage() {
		return respMessage;
	}


	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}
	
	
}

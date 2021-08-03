package com.ericsson.java.prototype.model;

public class Subscriber {
	
	private String id;
	private String name;
	private String msisdn;
	
	public Subscriber() {};
	
	public Subscriber(String id, String name, String msisdn) {
		this.id = id;
		this.name = name;
		this.msisdn = msisdn;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", name=" + name + ", msisdn=" + msisdn + "]";
	}
}

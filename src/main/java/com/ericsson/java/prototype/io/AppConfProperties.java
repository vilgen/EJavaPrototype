package com.ericsson.java.prototype.io;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Configuration
//@PropertySource("src/main/resources/application.properties")
@Validated
@ConfigurationProperties(prefix="app.conf")
public class AppConfProperties {
	
	public String getDataFilePath() {
		return data_file_path;
	}
	public void setDataFilePath(String dataFilePath) {
		this.data_file_path = dataFilePath;
	}
	public String getScheduler() {
		return scheduler;
	}
	public void setScheduler(String scheduler) {
		this.scheduler = scheduler;
	}
	private String data_file_path;
	private String scheduler;

}

package com.ericsson.java.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ericsson.java.prototype.services.SubscriberService;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class EricssonJavaPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EricssonJavaPrototypeApplication.class, args);
	}
}

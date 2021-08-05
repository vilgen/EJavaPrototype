package com.ericsson.java.prototype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.ericsson.java.prototype.model.Subscriber;
import com.ericsson.java.prototype.persistency.Persistence;
import com.ericsson.java.prototype.services.SubscriberService;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class EricssonJavaPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EricssonJavaPrototypeApplication.class, args);
	}

	@Component
	public class CommandLineAppStartupRunner implements CommandLineRunner {
		@Autowired
		SubscriberService subservice;

		@Override
		public void run(String... args) throws Exception {

			Persistence ps = new Persistence();
			List<Subscriber> subscribers = ps.Init();

			for (Subscriber s : subscribers) {

				try {
					if (s != null) {
						subservice.createSubscriber(s);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

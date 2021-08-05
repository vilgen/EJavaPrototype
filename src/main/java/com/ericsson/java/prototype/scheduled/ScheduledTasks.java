package com.ericsson.java.prototype.scheduled;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ericsson.java.prototype.model.Subscriber;
import com.ericsson.java.prototype.persistency.Persistence;
import com.ericsson.java.prototype.services.SubscriberService;

@Component
@PropertySource("file:app.properties")
public class ScheduledTasks {
	
	@Autowired
    SubscriberService subservice;
	
	@Scheduled(cron = "${cron.expression}")
    public void scheduleTaskWithCronExpression() {
		
		
		List<Subscriber> subs = new ArrayList<>();
		
		subs = subservice.getAllSubscribers();
		
		Persistence p = new Persistence();
		p.writeCacheDataToFile(subs);
		
	}

}

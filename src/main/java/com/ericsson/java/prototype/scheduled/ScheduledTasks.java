package com.ericsson.java.prototype.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ericsson.java.prototype.model.Subscriber;
import com.ericsson.java.prototype.services.SubscriberService;

@Component
public class ScheduledTasks {
	
	@Autowired
    SubscriberService subservice;
	
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Scheduled(fixedRate = 2000)
    public void scheduleTaskWithFixedRate() {
		
		logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
		
		List<Subscriber> subs = new ArrayList<>();
		
		subs = subservice.getAllSubscribers();
		
		for(Subscriber s : subs) {
			
			System.out.println(s.getName());
		}
    }

    public void scheduleTaskWithFixedDelay() {}

    public void scheduleTaskWithInitialDelay() {}

    public void scheduleTaskWithCronExpression() {}

}

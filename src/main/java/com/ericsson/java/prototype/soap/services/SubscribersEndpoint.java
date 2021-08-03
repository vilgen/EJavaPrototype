package com.ericsson.java.prototype.soap.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ericsson.java.prototype.model.Subscriber;
import com.ericsson.java.prototype.services.SubscriberService;

@Endpoint
public class SubscribersEndpoint {

	@Autowired
	SubscriberService subservice;

	@PayloadRoot(namespace = "http://www.ericsson.com/java/prototype/soap/services", localPart = "getAllSubscribersRequest")
	@ResponsePayload
	public GetAllSubscribersResponse processCourseDetailsRequest(@RequestPayload GetAllSubscribersRequest request) {
		GetAllSubscribersResponse response = new GetAllSubscribersResponse();

		List<Subscriber> subList = new ArrayList<>(); // creation of a subscriber list from subscriber model
		subList = subservice.getAllSubscribers(); // get all subscribers from subscriber service
		
		List<Subscribers> subscribersList = new ArrayList<Subscribers>(); // soap subscribers response list object

		// fill soap subscribers response object from subscriber model
		for (Subscriber sub : subList) {
			Subscribers subscribers = new Subscribers(); // soap subscribers object
			subscribers.setId(sub.getId());
			subscribers.setName(sub.getName());
			subscribers.setMsisdn(sub.getMsisdn());
			subscribersList.add(subscribers);
		}

		response.getSubscribers().addAll(subscribersList); // add subscribers to the response list

		return response;
	}
}

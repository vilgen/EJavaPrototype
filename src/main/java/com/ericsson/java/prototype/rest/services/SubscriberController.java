package com.ericsson.java.prototype.rest.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.java.prototype.model.Subscriber;
import com.ericsson.java.prototype.services.ServiceResponse;
import com.ericsson.java.prototype.services.SubscriberService;

@RestController
public class SubscriberController {
	
    private static final Logger log = LoggerFactory.getLogger(SubscriberController.class);
	
	@Autowired
	SubscriberService subservice;

	@GetMapping("/subscriber")
	public List<Subscriber> getAllSubscribers() {
		return subservice.getAllSubscribers();
	}

	@GetMapping("/subscriber/{id}")
	public Subscriber getSubscriber(@PathVariable String id) {
		return subservice.getSubscriberById(id);
	}

	@PostMapping("/subscriber")
	public ResponseEntity<?> createSubscriber(@RequestBody Subscriber sub) {
		
		if(sub.getId().equals(null) || sub.getId().equals(""))
			return ResponseEntity.ok("Subscriber Id cannot be NULL!");
		
		try {
			
			subservice.createSubscriber(sub);
			log.info("/subscriber[POST]" + sub.toString());
			
			return ResponseEntity.ok(HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(e.getMessage().toString());
		}
	}

	@PutMapping("/subscriber")
	public ResponseEntity<?> updateSubscriber(@RequestBody Subscriber sub) {
		
		if(sub.getId().equals(null) || sub.getId().equals(""))
			return ResponseEntity.ok("Subscriber Id cannot be NULL!");
		
		try {
			ServiceResponse resp = new ServiceResponse();
			resp = subservice.updateSubscriber(sub);
			
			if(resp.getRespId() == 404)
				return ResponseEntity.ok(resp.getRespMessage());
			
			log.info("/subscriber[PUT]" + sub.toString());
			return ResponseEntity.ok(HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(e.getMessage().toString());
		}
	}

	@DeleteMapping("/subscriber")
	public ResponseEntity<?> deleteSubscriber(@RequestBody Subscriber sub) {

		if(sub.getId().equals(null) || sub.getId().equals(""))
			return ResponseEntity.ok("Subscriber Id cannot be NULL!");
		
		try {
			ServiceResponse resp = new ServiceResponse();
			resp = subservice.deleteSubscriber(sub);
			
			if(resp.getRespId() == 404)
				return ResponseEntity.ok(resp.getRespMessage());
			
			log.info("/subscriber[DELETE] [id=" + sub.getId().toString() + "]");
			return ResponseEntity.ok(HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(e.getMessage().toString());
		}
	}

}

package com.ericsson.java.prototype.rest.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.java.prototype.dao.Subscriber;

@RestController
public class SubscriberController {
	
	@GetMapping("/subscriber")
	public String getSubscriber() {
		return "Greetings from Spring Boot!";
	}
	
	@PostMapping("/subscriber")
	public ResponseEntity<?> createSubscriber(@RequestBody Subscriber sub) {
		//System.out.println(sub.getMsisdn());
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PutMapping("/subscriber")
	public ResponseEntity<?> updateSubscriber(@RequestBody Subscriber sub) {
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@DeleteMapping("/subscriber")
	public ResponseEntity<?> deleteSubscriber(@RequestBody Subscriber sub) {

		if(sub.getId() != "")
			return ResponseEntity.ok(HttpStatus.OK);
		else
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}
}

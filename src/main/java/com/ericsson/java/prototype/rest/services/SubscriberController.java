package com.ericsson.java.prototype.rest.services;

import java.util.List;

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
import com.ericsson.java.prototype.services.SubscriberService;

@RestController
public class SubscriberController {

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
		subservice.createSubscriber(sub);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@PutMapping("/subscriber")
	public ResponseEntity<?> updateSubscriber(@RequestBody Subscriber sub) {
		subservice.updateSubscriber(sub);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@DeleteMapping("/subscriber")
	public ResponseEntity<?> deleteSubscriber(@RequestBody Subscriber sub) {

		if (sub.getId() != "") {
			subservice.deleteSubscriber(sub);
			return ResponseEntity.ok(HttpStatus.OK);
		} else
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}

}

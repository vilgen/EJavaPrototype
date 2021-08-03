package com.ericsson.java.prototype.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ericsson.java.prototype.model.Subscriber;

@Service
@CacheConfig(cacheNames = { "subscribers" })
public class SubscriberService {

	private List<Subscriber> subList = new ArrayList<>();

	@Cacheable
	public Subscriber getSubscriberById(String id) {

		Subscriber sb = new Subscriber();

		for (Subscriber sub : this.subList) {
			if (sub.getId().equals(id)) {
				sb = sub;
			}
		}

		return sb;
	}

	@Cacheable
	public List<Subscriber> getAllSubscribers() {
		return this.subList;
	}

	@CachePut
	public void createSubscriber(Subscriber sub) {
		this.subList.add(sub);
	}

	@CachePut
	public void updateSubscriber(Subscriber sub) {
		// System.out.println("Subscriber updated: \n" + sub.toString());
		
		for (Subscriber sb : this.subList) {
			
			if (sb.getId().equals(sub.getId())) {
				
				int index = this.subList.indexOf(sb);
				this.subList.set(index, sub);
			}
		}
	}

	@CachePut
	public void deleteSubscriber(Subscriber sub) {
		//System.out.println("Subscriber deleted: \n" + sub.toString());
		for (Iterator<Subscriber> iterator = subList.iterator(); iterator.hasNext();) {
			
			if (iterator.next().getId().equals(sub.getId())) {
				
				iterator.remove();
			}
		}
		
	}
}

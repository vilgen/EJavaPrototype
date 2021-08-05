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
	public List<Subscriber> getSubscriberById(String id) {

		List<Subscriber> sList = new ArrayList<>();

		for (Subscriber sub : this.subList) {
			if (sub.getId().equals(id))
				sList.add(sub);

		}

		return sList;
	}

	@Cacheable
	public List<Subscriber> getAllSubscribers() {
		return this.subList;
	}

	@CachePut
	public void createSubscriber(Subscriber sub) throws Exception {
		this.subList.add(sub);
	}

	@CachePut
	public ServiceResponse updateSubscriber(Subscriber sub) throws Exception {

		ServiceResponse sr = new ServiceResponse();

		for (Subscriber sb : this.subList) {

			if (sb.getId().equals(sub.getId())) {

				int index = this.subList.indexOf(sb);
				this.subList.set(index, sub);

				sr.setRespMessage("Success");
			}

			else {

				sr.setRespId(404);
				sr.setRespMessage("Subscriber Not Found!");
			}
		}

		return sr;
	}

	@CachePut
	public ServiceResponse deleteSubscriber(Subscriber sub) throws Exception {

		ServiceResponse sr = new ServiceResponse();
		for (Iterator<Subscriber> iterator = subList.iterator(); iterator.hasNext();) {

			if (iterator.next().getId().equals(sub.getId())) {

				iterator.remove();

				sr.setRespId(200);
				sr.setRespMessage("Success");
			}

			else {
				sr.setRespId(404);
				sr.setRespMessage("Subscriber Not Found!");
			}
		}

		return sr;

	}
}

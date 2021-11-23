package com.rdb_backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdb_backend.models.Event;
import com.rdb_backend.repository.EventRepository;



@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	
	@Autowired
	private AddressService addressService;
	
	public Event saveEvent(Event event) {
		return repository.save(event);
	}

	public List<Event> saveEvent(List<Event> event) {
		return repository.saveAll(event);
	}

	public List<Event> getEvent() {
		return repository.findAll();
	}

	public Event getEventById(Long id) {		
		return repository.findById(id).orElse(null);
	}
	
	public Event getEventByName(String name) {
		return repository.findByName(name);
	}

	@Transactional
	public Event updateEvent(Event event) {
		Event existEvent = repository.findById(event.getId()).orElse(null);
	
		existEvent.setName(event.getName());
		existEvent.setDescription(event.getDescription());
		addressService.updateAddress(event.getAddress());
		existEvent.setStatus(event.getStatus());
		existEvent.setStartDate(event.getStartDate());
		existEvent.setEndDate(event.getEndDate());
		return repository.save(existEvent);		
	}
	
	@Transactional
	public String deleteEvent(Long id) {
		repository.deleteById(id);
		return "Event remove!" + id;
	}
	
}

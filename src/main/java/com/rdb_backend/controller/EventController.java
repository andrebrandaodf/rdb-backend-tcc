package com.rdb_backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rdb_backend.models.Event;
import com.rdb_backend.repository.EventRepository;
import com.rdb_backend.service.EventService;


@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private EventRepository eventRepository;

	@PostMapping("/event")
	@ResponseStatus(HttpStatus.CREATED)
	public Event addEvent(@Valid @RequestBody Event event) {
		return eventService.saveEvent(event);
	}

	@GetMapping("/event")
	public List<Event> findAll() {
		return eventService.getEvent();
	}

	@GetMapping("/event/{id}")
	public Event findEventById(@PathVariable Long id) {
		return eventService.getEventById(id);
	}

	@PutMapping("/event/{id}")
	public ResponseEntity<Event> updateEvent(@Valid @PathVariable Long id, @RequestBody Event event) {
		if (!eventRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		event.setId(id);
		event = eventService.saveEvent(event);
		return ResponseEntity.ok(event);
	}

	@DeleteMapping("/event/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
		if (!eventRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		eventService.deleteEvent(id);
		return ResponseEntity.noContent().build();
	}
}

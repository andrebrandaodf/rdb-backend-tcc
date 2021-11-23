package com.rdb_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdb_backend.models.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

	Event findByName(String name);

	Optional<Event> findById(Long id);

	void deleteById(Long id);
	
}

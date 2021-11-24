package com.rdb_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdb_backend.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	Contact findByName(String name);

	Optional<Contact> findById(Long id);

	void deleteById(Long id);
}

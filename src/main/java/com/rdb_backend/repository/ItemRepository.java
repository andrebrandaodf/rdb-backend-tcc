package com.rdb_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdb_backend.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findByName(String name);

	Optional<Item> findById(Long id);

	void deleteById(Long id);
}


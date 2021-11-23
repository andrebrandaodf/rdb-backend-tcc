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

import com.rdb_backend.models.Item;
import com.rdb_backend.repository.ItemRepository;
import com.rdb_backend.service.ItemService;


@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	@PostMapping("/item")
	@ResponseStatus(HttpStatus.CREATED)
	public Item additem(@Valid @RequestBody Item item) {
		return itemService.saveItem(item);
	}

	@GetMapping("/item")
	public List<Item> findAll() {
		return itemService.getItem();
	}

	@GetMapping("/item/{id}")
	public Item finditemById(@PathVariable Long id) {
		return itemService.getItemById(id);
	}

	@PutMapping("/item/{id}")
	public ResponseEntity<Item> updateitem(@Valid @PathVariable Long id, @RequestBody Item item) {
		if (!itemRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		item.setId(id);
		item = itemService.saveItem(item);
		return ResponseEntity.ok(item);
	}

	@DeleteMapping("/item/{id}")
	public ResponseEntity<Void> deleteitem(@PathVariable Long id) {
		if (!itemRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		itemService.deleteItem(id);
		return ResponseEntity.noContent().build();
	}
}

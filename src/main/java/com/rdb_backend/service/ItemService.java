package com.rdb_backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdb_backend.models.Item;
import com.rdb_backend.repository.ItemRepository;



@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;
	
	public Item saveItem(Item item) {
		return repository.save(item);
	}

	public List<Item> saveItem(List<Item> Item) {
		return repository.saveAll(Item);
	}

	public List<Item> getItem() {
		return repository.findAll();
	}

	public Item getItemById(Long id) {		
		return repository.findById(id).orElse(null);
	}
	
	public Item getItemByName(String name) {
		return repository.findByName(name);
	}

	@Transactional
	public Item updateItem(Item Item) {
		Item existItem = repository.findById(Item.getId()).orElse(null);
	
		existItem.setName(Item.getName());
		existItem.setCategory(Item.getCategory());
		existItem.setDescription(Item.getDescription());
		return repository.save(existItem);		
	}
	
	@Transactional
	public String deleteItem(Long id) {
		repository.deleteById(id);
		return "Item remove!" + id;
	}
	
}

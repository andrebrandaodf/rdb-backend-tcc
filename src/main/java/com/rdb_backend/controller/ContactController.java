package com.rdb_backend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rdb_backend.models.Contact;
import com.rdb_backend.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping("/contact")
	@ResponseStatus(HttpStatus.CREATED)
	public Contact addContact(@RequestBody @Valid Contact contact) {
		return contactService.saveContact(contact);
	}
}

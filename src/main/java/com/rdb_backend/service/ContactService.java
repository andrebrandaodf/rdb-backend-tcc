package com.rdb_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.rdb_backend.exception.ApiException;
import com.rdb_backend.models.Contact;
import com.rdb_backend.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;
	
	@Autowired
	private SendEmailService sendEmailService;

    @Autowired
    private SpringTemplateEngine templateEngine;

	public Contact saveContact(Contact contact) {
		try {
			Contact saved = repository.save(contact);

			Context context = new Context();
			context.setVariable("name", saved.getName());
			context.setVariable("phone", saved.getPhone());
			context.setVariable("email", saved.getEmail());
//			context.setVariable("talkTo", saved.getTalkTo());
			context.setVariable("message", saved.getMessage());
			
			String html = templateEngine.process("email", context);

			 sendEmailService.sendHtmlMessage(saved.getTalkTo().getEmail(), saved.getSubjectMatter(), html);

			return saved;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException("Erro ao salvar e enviar solicitação de contato. " + e.getMessage());
		}
	}
	
	public List<Contact> saveContact(List<Contact> contact){
		return repository.saveAll(contact);
	}
}

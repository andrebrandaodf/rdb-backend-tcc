package com.rdb_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rdb_backend.service.CepService;

@RestController
public class CepController {
	
	@Autowired
	CepService cepService;
	
	@GetMapping("/cep/{cep}")
	public String getCep(@PathVariable String cep ) {
		System.out.println(cep);
		return cepService.getCepInformation(cep);
	}
}
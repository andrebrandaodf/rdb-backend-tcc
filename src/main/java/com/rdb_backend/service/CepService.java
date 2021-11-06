package com.rdb_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

	public String getCepInformation(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(cep);
		return restTemplate.getForObject("https://viacep.com.br/ws/"+cep+"/json/", String.class);	
		
	}
}
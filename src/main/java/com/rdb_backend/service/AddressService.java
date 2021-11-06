package com.rdb_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdb_backend.models.Address;
import com.rdb_backend.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repositoryAddress;
	
	public Address saveAddress(Address address) {
		return repositoryAddress.save(address);
	}
	
	public List<Address> saveAddresss(List<Address> address) {
		return repositoryAddress.saveAll(address);
	}


	public List<Address> getAddresss() {
		return repositoryAddress.findAll();
	}

	public Address getAddressById(Long id) {
		return repositoryAddress.findById(id).orElse(null);
	}
	
	public Address getAddressByCep(String cep) {
		return repositoryAddress.findByCep(cep);
	}

	public Address updateAddress(Address address) {
		Address existAddress = repositoryAddress.findById(address.getId()).orElse(null);
		
		existAddress.setCep(address.getCep());
		existAddress.setLogradouro(address.getLogradouro());
		existAddress.setBairro(address.getBairro());
		existAddress.setLocalidade(address.getLocalidade());
		existAddress.setUf(address.getUf());
		existAddress.setComplemento(address.getComplemento());
		return repositoryAddress.save(existAddress);		
	}
	
	public String deleteAddress(Long id) {
		repositoryAddress.deleteById(id);
		return "address remove!" + id;
	}
}

package com.rdb_backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdb_backend.models.Donor;
import com.rdb_backend.repository.DonorRepository;


@Service
public class DonorService {

	@Autowired
	private DonorRepository repository;
	
	@Autowired
	private AddressService addressService;
	
	public Donor saveDonor(Donor donor) {
		return repository.save(donor);
	}

	public List<Donor> saveDonor(List<Donor> donor) {
		return repository.saveAll(donor);
	}

	public List<Donor> getDonor() {
		return repository.findAll();
	}

	public Donor getDonorById(Long id) {		
		return repository.findById(id).orElse(null);
	}
	
	public Donor getDonorByName(String name) {
		return repository.findByName(name);
	}

	@Transactional
	public Donor updateDonor(Donor donor) {
		Donor existDonor = repository.findById(donor.getId()).orElse(null);
	
		existDonor.setName(donor.getName());
		existDonor.setPhone(donor.getPhone());
		existDonor.setEmail(donor.getEmail());
		addressService.updateAddress(donor.getAddress());
		return repository.save(existDonor);		
	}
	
	@Transactional
	public String deleteDonor(Long id) {
		repository.deleteById(id);
		return "Donor remove!" + id;
	}
	
}

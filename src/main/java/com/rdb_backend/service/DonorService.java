package com.rdb_backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rdb_backend.models.Donor;
import com.rdb_backend.repository.DonorRepository;

public class DonorService {

	@Autowired
	private DonorRepository donorRepository;

	@Autowired
	private AddressService addressService;

	public Donor saveDonor(Donor donor) {
		return donorRepository.save(donor);
	}

	public List<Donor> saveDonor(List<Donor> donor) {
		return donorRepository.saveAll(donor);
	}

	public List<Donor> getDonor() {
		return donorRepository.findAll();
	}

	public Donor getDonorById(Long id) {
		return donorRepository.findById(id).orElse(null);
	}

	public Donor getDonorByName(String name) {
		return donorRepository.findByName(name);
	}

	@Transactional
	public Donor updateDonor(Donor donor) {
		Donor existDonor = donorRepository.findById(donor.getId()).orElse(null);

		existDonor.setName(donor.getName());
		existDonor.setPhone(donor.getPhone());
		existDonor.setEmail(donor.getEmail());
		addressService.updateAddress(donor.getAddress());
		return donorRepository.save(existDonor);
	}

	@Transactional
	public String deleteDonor(Long id) {
		donorRepository.deleteById(id);
		return "Donor remove!" + id;
	}

}
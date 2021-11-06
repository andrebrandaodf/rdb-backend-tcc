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

import com.rdb_backend.models.Donor;
import com.rdb_backend.repository.DonorRepository;
import com.rdb_backend.service.DonorService;

@RestController
public class DonorController {

	@Autowired
	private DonorService donorService;

	@Autowired
	private DonorRepository donorRepository;

	@PostMapping("/donor")
	@ResponseStatus(HttpStatus.CREATED)
	public Donor addDonor(@Valid @RequestBody Donor donor) {
		return donorService.saveDonor(donor);
	}

	@GetMapping("/donor")
	public List<Donor> findAll() {
		return donorService.getDonor();
	}

	@GetMapping("/donor/{id}")
	public Donor findDonorById(@PathVariable Long id) {
		return donorService.getDonorById(id);
	}

	@PutMapping("/donor/{id}")
	public ResponseEntity<Donor> updateDonor(@Valid @PathVariable Long id, @RequestBody Donor donor) {
		if (!donorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		donor.setId(id);
		donor = donorService.saveDonor(donor);
		return ResponseEntity.ok(donor);
	}

	@DeleteMapping("/Donor/{id}")
	public ResponseEntity<Void> deleteDonor(@PathVariable Long id) {
		if (!donorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		donorService.deleteDonor(id);
		return ResponseEntity.noContent().build();
	}
}
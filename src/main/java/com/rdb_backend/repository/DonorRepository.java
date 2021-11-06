package com.rdb_backend.repository;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rdb_backend.models.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

	Donor findByName(String name);

	Optional<Donor> findById(Long id);

	void deleteById(Long id);

	Page<Donor> findAllByOrderByCreatedDateDesc(Pageable pageable);
	
}

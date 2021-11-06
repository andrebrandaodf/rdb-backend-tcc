package com.rdb_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdb_backend.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	Optional<Address> findById(Long id);

	Address findByCep(String cep);
	
}
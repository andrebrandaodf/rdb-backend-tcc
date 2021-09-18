package com.rdb_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdb_backend.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	 User findByUsername(String username);
}


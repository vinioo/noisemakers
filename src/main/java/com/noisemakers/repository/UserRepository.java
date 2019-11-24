package com.noisemakers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noisemakers.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findById(long id);
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
}

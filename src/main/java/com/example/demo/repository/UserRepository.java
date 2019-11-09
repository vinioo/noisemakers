package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findById(long id);
	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);
}

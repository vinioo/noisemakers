package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")

public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
	@Valid
	@PostMapping("/login")
	public ResponseEntity<?> getUserInfo(@RequestBody User user) {
		try {
			User foundUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

			if (!foundUser.getEmail().isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(foundUser);
			}
			return null;
		} catch (Exception err) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos!");
		}

	}

}

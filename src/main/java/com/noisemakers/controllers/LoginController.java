package com.noisemakers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noisemakers.exceptions.ApiInvalidRequestException;
import com.noisemakers.models.User;
import com.noisemakers.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")

public class LoginController {

	@Autowired
	UserRepository userRepository;

	@Valid
	@PostMapping("/login")
	public ResponseEntity<?> getUserInfo(@RequestBody User user) {
		User foundUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if (foundUser == null) {
			throw new ApiInvalidRequestException("Usuário ou senha inválidos!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(foundUser);

	}

}

package com.noisemakers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

public class SignupController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/signup")
	public User saveUser(@Valid @RequestBody User user) {
		User existentUser = userRepository.findByEmail(user.getEmail());
		if (existentUser == null) {
			return userRepository.save(user);
		}
		throw new ApiInvalidRequestException("Usuário já cadastrado!");
	}

}

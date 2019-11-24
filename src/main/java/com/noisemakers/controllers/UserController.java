package com.noisemakers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noisemakers.exceptions.ApiRequestException;
import com.noisemakers.models.User;
import com.noisemakers.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")

public class UserController {

	@Autowired
	UserRepository userRepository;


	@GetMapping("/user/{id}")
	public User getUser(@Valid @PathVariable(name = "id") long id) {
		try {
			return userRepository.findById(id);
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao buscar usuário pelo ID!", handlerException);
		}
	}
	

	@PutMapping("/user")
	public User updateUser(@Valid @RequestBody User user) {
		try {
			return userRepository.save(user);
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao atualizar usuário!", handlerException);
		}
	}



}

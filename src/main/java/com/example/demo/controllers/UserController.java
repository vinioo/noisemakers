package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.models.User;
import com.example.demo.models.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")

public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserInfoRepository userInfoRepository;

	@GetMapping("/user")
	public List<UserInfo> listAllUsers() {
		try {
			return userInfoRepository.findAll();
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao buscar usuários!", handlerException);
		}
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable(name = "id") long id) {
		try {
			return userRepository.findById(id);
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao buscar usuário pelo ID!", handlerException);
		}
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		try {
			return userRepository.save(user);
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao atualizar usuário!", handlerException);
		}
	}

	@GetMapping("/getAllUserInfoSample")
	public List<UserInfo> getAllUserInfoSample() {
		try {
			return userInfoRepository.getAllUserInfoSample();
		} catch(Exception handlerException) {
			throw new ApiRequestException("Erro ao obter exemplo de usuários!", handlerException);
		}
	}

	@PostMapping("/updateUserInfo")
	public UserInfo updateUserInfo(@Valid @RequestBody UserInfo user) {
		try {
			return userInfoRepository.save(user);
		} catch(Exception handlerException) {
			throw new ApiRequestException("Erro ao atualizar informações do usuário!", handlerException);
		}
	}

}

package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return userInfoRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable(name = "id") long id) {
		return userRepository.findById(id);
	}

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

	@DeleteMapping("/user")
	public void deleteUser(@RequestBody User produto) {
		userRepository.delete(produto);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User produto) {
		return userRepository.save(produto);
	}

	@GetMapping("/getAllUserInfoSample")
	public List<UserInfo> getAllUserInfoSample() {
		return userInfoRepository.getAllUserInfoSample();
	}

	@PostMapping("/updateUserInfo")
	public UserInfo updateUserInfo(@Valid @RequestBody UserInfo user) {
		return userInfoRepository.save(user);
	}

}

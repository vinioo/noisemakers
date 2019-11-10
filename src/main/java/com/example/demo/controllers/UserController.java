package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.models.UserInfo;
import com.example.demo.models.UserSkills;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserSkillsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserSkillsRepository userSkillsRepository;
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@GetMapping("/user")
	public List<User> listAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable(name="id") long id){
		return userRepository.findById(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> getUserInfo(@RequestBody User user) {
		try {
			User foundUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
			
			if (!foundUser.getEmail().isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body("Usuário autenticado com sucesso!!!");
			}
			return null;
		} catch(Exception err) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body("Usuário ou senha incorretos!");
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
	
	@PostMapping("/updateUserSkills")
	public UserSkills updateUserSkills(@RequestBody UserSkills user) {
		// TODO: foreach to insert array of skills
		return userSkillsRepository.save(user);
	}
	
	@GetMapping("/getAllUserInfoSample")
	public List<UserInfo> getAllUserInfoSample() {
		return userInfoRepository.getAllUserInfoSample();
	}
	
	@PostMapping("/updateUserInfo")
	public UserInfo updateUserInfo(@RequestBody UserInfo user) {
		return userInfoRepository.save(user);
	}
	 


}

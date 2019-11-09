package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user")
	public List<User> listAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable(value="id") long id){
		return userRepository.findById(id);
	}
	
	@PostMapping("/login")
	public User getUserInfo(@RequestBody User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User produto) {
		return userRepository.save(produto);
	}
	
	@DeleteMapping("/user")
	public void deleteUser(@RequestBody User produto) {
		userRepository.delete(produto);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User produto) {
		return userRepository.save(produto);
	}
	 

}

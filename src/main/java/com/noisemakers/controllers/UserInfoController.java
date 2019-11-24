package com.noisemakers.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noisemakers.exceptions.ApiRequestException;
import com.noisemakers.models.UserInfo;
import com.noisemakers.repository.UserInfoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")

public class UserInfoController {

	@Autowired
	UserInfoRepository userInfoRepository;

	@GetMapping("/userinfo/{id}")
	public UserInfo getUserInfo(@PathVariable(name = "id") long id) {
		try {
			return userInfoRepository.findByUser_id(id);
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao buscar usuário pelo ID!", handlerException);
		}
	}

	@GetMapping("/getAllUserInfoSample")
	public List<UserInfo> getAllUserInfoSample() {
		try {
			return userInfoRepository.getAllUserInfoSample();
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao obter exemplo de usuários!" + handlerException);
		}
	}

	@PostMapping("/updateUserInfo")
	public UserInfo updateUserInfo(@Valid @RequestBody UserInfo user) {
		try {
			return userInfoRepository.save(user);
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao atualizar informações do usuário!", handlerException);
		}
	}

}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

}

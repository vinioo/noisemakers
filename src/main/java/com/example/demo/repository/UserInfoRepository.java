package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
	@Query(value = "SELECT * FROM UserInfo LIMIT 4", nativeQuery = true)
	List<UserInfo> getAllUserInfoSample();
}

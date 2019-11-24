package com.noisemakers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.noisemakers.models.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
	@Query(value = "SELECT * FROM userinfo WHERE user_id = ?1", nativeQuery = true)
	UserInfo findByUser_id(long id);
	@Query(value = "SELECT * FROM userinfo ORDER BY random() LIMIT 4 ", nativeQuery = true)
	List<UserInfo> getAllUserInfoSample();
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Band;

public interface BandRepository extends JpaRepository<Band, Long>{
	Band findById(long id);
}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Band;

public interface BandRepository extends JpaRepository<Band, Long>{
	Band findById(long id);
	@Query(value = "SELECT * FROM Band LIMIT 4", nativeQuery = true)
	List<Band> getAllBandInfoSample();
}

package com.noisemakers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.noisemakers.models.Band;

public interface BandRepository extends JpaRepository<Band, Long>{
	Band findById(long id);
	@Query(value = "SELECT * FROM Band ORDER BY random() LIMIT 4 ", nativeQuery = true)
	List<Band> getAllBandInfoSample();
}

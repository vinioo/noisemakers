	package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Band;
import com.example.demo.repository.BandRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")

public class BandController {

	@Autowired
	BandRepository bandRepository;

	@GetMapping("/band")
	public List<Band> listAllBands() {
		return bandRepository.findAll();
	}

	@DeleteMapping("/band")
	public void deleteBand(@RequestBody Band band) {
		bandRepository.delete(band);
	}

	@GetMapping("/band/{id}")
	public Band getBand(@PathVariable(name = "id") long id) {
		return bandRepository.findById(id);
	}

	@PutMapping("/band")
	public Band updateBand(@RequestBody Band band) {
		return bandRepository.save(band);
	}

	@PostMapping("/band")
	public Band insertBand(@Valid @RequestBody Band band) {
		return bandRepository.save(band);
	}

	@GetMapping("/getAllBandInfoSample")
	public List<Band> getAllBandInfoSample() {
		return bandRepository.getAllBandInfoSample();
	}

}

package com.example.demo.controllers;

import com.example.demo.models.Band;
import com.example.demo.models.User;
import com.example.demo.models.UserInfo;
import com.example.demo.models.UserSkills;
import com.example.demo.repository.BandRepository;
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

public class BandController {
	
	@Autowired
	BandRepository bandRepository;
	
	@GetMapping("/band")
	public List<Band> listAllBands(){
		return bandRepository.findAll();
	}
	
	@DeleteMapping("/band")
	public void deleteBand(@RequestBody Band band) {
		bandRepository.delete(band);
	}	
	
	@GetMapping("/band/{id}")
	public Band getBand(@PathVariable(name="id") long id){
		return bandRepository.findById(id);
	}
	
	@PutMapping("/band")
	public Band updateBand(@RequestBody Band band) {
		return bandRepository.save(band);
	}
	
	@PostMapping("/band")
	public Band insertBand(@RequestBody Band band) {
		return bandRepository.save(band);
	}
	@GetMapping("/getAllBandInfoSample")
	public List<Band> getAllBandInfoSample() {
		return bandRepository.getAllBandInfoSample();
	}
	 

}

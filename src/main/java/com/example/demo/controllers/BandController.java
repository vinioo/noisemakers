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

import com.example.demo.exceptions.ApiRequestException;
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
		try {
			return bandRepository.findAll();
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao listar todas as bandas!", handlerException);
		}
	}

	@DeleteMapping("/band")
	public void deleteBand(@RequestBody Band band) {
		try {
			bandRepository.delete(band);
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao deletar banda!", handlerException);
		}
	}

	@GetMapping("/band/{id}")
	public Band getBand(@PathVariable(name = "id") long id) {
		try {
			return bandRepository.findById(id);
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao listar banda pelo ID!", handlerException);
		}
	}

	@PutMapping("/band")
	public Band updateBand(@RequestBody Band band) {
		try {
			return bandRepository.save(band);
		} catch (Exception handlerException) {
			throw new ApiRequestException("Erro ao atualizar banda!", handlerException);
		}
	}

	@PostMapping("/band")
	public Band insertBand(@Valid @RequestBody Band band) {
		try {
			return bandRepository.save(band);
		} catch(Exception handlerException) {
			throw new ApiRequestException("Erro ao salvar banda!", handlerException);
		}
	}

	@GetMapping("/getAllBandInfoSample")
	public List<Band> getAllBandInfoSample() {
		try {
			return bandRepository.getAllBandInfoSample();
		} catch(Exception handlerException) {
			throw new ApiRequestException("Erro ao obter bandas de exemplo!", handlerException);
		}
	}

}

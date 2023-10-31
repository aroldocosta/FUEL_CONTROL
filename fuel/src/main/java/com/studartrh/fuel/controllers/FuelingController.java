package com.studartrh.fuel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studartrh.fuel.dto.FuelingDTO;
import com.studartrh.fuel.services.FuelingService;

@RestController
@RequestMapping("fuelings")
public class FuelingController {
	
	@Autowired
	private FuelingService service;
	
	@GetMapping("")
	public ResponseEntity<List<FuelingDTO> > getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<FuelingDTO> get(@PathVariable("id") Long id) {     
		return service.get(id);
	}
	
	@PostMapping(value = "/sensors")
	public ResponseEntity<FuelingDTO> save(@RequestBody FuelingDTO data) {
		return service.save(data);
	}
	
	@PutMapping(value = "/sensors/{id}")
	public ResponseEntity<FuelingDTO> update(@PathVariable("id") Long id, @RequestBody FuelingDTO data) {
		return service.update(id);
	}
	
	@DeleteMapping(value = "/sensors/{id}")
	public ResponseEntity<FuelingDTO> delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
}

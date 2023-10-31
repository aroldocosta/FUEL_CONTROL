package com.studartrh.fuel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studartrh.fuel.dto.PumpDTO;
import com.studartrh.fuel.services.PumpService;

@RestController
@RequestMapping("pumps")
public class PumpController {

	@Autowired
	private PumpService service;

	@GetMapping("")
	public ResponseEntity<List<PumpDTO> > getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<PumpDTO> get(@PathVariable("id") Long id) {     
		return service.get(id);
	}
	
	@PostMapping(value = "/pumps")
	public ResponseEntity<PumpDTO> save(@RequestBody PumpDTO data) {
		return service.save(data);
	}
	
	@PutMapping(value = "/pumps/{id}")
	public ResponseEntity<PumpDTO> update(@PathVariable("id") Long id, @RequestBody PumpDTO data) {
		return service.update(id);
	}
	
	@DeleteMapping(value = "/pumps/{id}")
	public ResponseEntity<PumpDTO> delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
}

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

import com.studartrh.fuel.dto.FuelingDTO;
import com.studartrh.fuel.dto.TotalsDTO;
import com.studartrh.fuel.services.FuelingService;
import com.studartrh.fuel.services.UserService;

@RestController
@RequestMapping("fuelings")
public class FuelingController {
	
	@Autowired
	private FuelingService service;

	@GetMapping()
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
	public ResponseEntity<List<FuelingDTO> > getAll() {
		return service.getAll();
	}
	@GetMapping(value = "/{id}")	
	public ResponseEntity<FuelingDTO> get(@PathVariable("id") Long id) {     
		return service.get(id);
	}
	@PostMapping()
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
	public ResponseEntity<FuelingDTO> save(@RequestBody FuelingDTO dto) {
		return service.save(dto);
	}
	@PutMapping()
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.PUT)
	public ResponseEntity<FuelingDTO> update(@RequestBody FuelingDTO dto) {
		return service.update(dto);
	}
	@DeleteMapping(value = "{id}")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.DELETE)
	public ResponseEntity<FuelingDTO> delete(@PathVariable("id") Long id) {
		
		
		
		return service.delete(id);
	}
	
	@GetMapping(value = "/totals")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
	public ResponseEntity<TotalsDTO> getTotals() {
		return service.totals();
	}
}

package com.studartrh.fuel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studartrh.fuel.dto.TankDTO;
import com.studartrh.fuel.services.TankService;

@RestController
@RequestMapping("tanks")
public class TankController {

	@Autowired
	private TankService service;
	
	@GetMapping()
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
	ResponseEntity<List<TankDTO>> getAll() {
		return service.getAll();
	}
	
}

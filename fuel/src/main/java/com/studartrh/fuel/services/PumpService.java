package com.studartrh.fuel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studartrh.fuel.dto.PumpDTO;
import com.studartrh.fuel.entity.Pump;
import com.studartrh.fuel.repository.PumpRepository;

@Service
public class PumpService {
	
	@Autowired
	private PumpRepository repository;
	
	public ResponseEntity<List<PumpDTO> > getAll() {
	
		try {
			List<PumpDTO> resp = repository.findAll().stream().map(PumpDTO::new).toList();		
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public ResponseEntity<PumpDTO> get(Long id) {	
		
		try {
			PumpDTO resp = repository.findById(id).stream().map(PumpDTO::new).findAny().get();
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
}

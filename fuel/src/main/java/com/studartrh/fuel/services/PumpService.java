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
	
	private static String UNKNOWN_ERROR  = "UNKNOWN_ERROR";
	private static String DUPLICATED_KEY = "DUPLICATED_KEY";
	
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
	
	public ResponseEntity<PumpDTO> save(PumpDTO data) {

		try {
			Pump pump = new Pump(data);
			PumpDTO resp = new PumpDTO(repository.save(pump));	
			return ResponseEntity.ok(resp);
		} catch (DataIntegrityViolationException e) {
			System.out.println(e.getMessage()); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public ResponseEntity<PumpDTO> update(Long id) {
		
		try {
			Pump pump = repository.findById(id).get();
			PumpDTO resp = new PumpDTO(repository.save(pump));
			return ResponseEntity.ok(resp);
		} catch (DataIntegrityViolationException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public ResponseEntity<PumpDTO> delete(Long id) {
		
		try {
			Pump pump = repository.findById(id).get();
			repository.delete(pump);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

package com.studartrh.fuel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studartrh.fuel.dto.FuelingDTO;
import com.studartrh.fuel.entity.Fueling;
import com.studartrh.fuel.repository.FuelingRepository;

@Service
public class FuelingService {
	
	@Autowired
	private FuelingRepository repository;
	
	public ResponseEntity<List<FuelingDTO> > getAll() {
	
		try {
			List<FuelingDTO> resp = repository.findAll().stream().map(FuelingDTO::new).toList();		
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public ResponseEntity<FuelingDTO> get(Long id) {	
		
		try {
			FuelingDTO resp = repository.findById(id).stream().map(FuelingDTO::new).findAny().get();
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public ResponseEntity<FuelingDTO> save(FuelingDTO data) {
		String message = "";
		try {
			Fueling fueling = new Fueling(data);
			FuelingDTO resp = new FuelingDTO(repository.save(fueling));	
			return ResponseEntity.ok(resp);
		} catch (DataIntegrityViolationException e) {
			message = e.getMessage();
		} catch (Exception e) {
			message = e.getMessage();
		}
		return ResponseEntity.ok(new FuelingDTO(null, null, null, message));
	}
	
	public ResponseEntity<FuelingDTO> update(Long id) {
		String message = "";
		try {
			Fueling fueling = repository.findById(id).get();
			FuelingDTO resp = new FuelingDTO(repository.save(fueling));
			return ResponseEntity.ok(resp);
		} catch (DataIntegrityViolationException e) {
			message = e.getMessage();
		} catch (Exception e) {
			message = e.getMessage();
		}
		return ResponseEntity.ok(new FuelingDTO(null, null, null, message));
	}
	
	public ResponseEntity<FuelingDTO> delete(Long id) {
		String message = "";
		try {
			Fueling fueling = repository.findById(id).get();
			repository.delete(fueling);
			return ResponseEntity.ok(new FuelingDTO(fueling));
		} catch (Exception e) {
			message = e.getMessage();
		}
		return ResponseEntity.ok(new FuelingDTO(null, null, null, message));
	}	
}

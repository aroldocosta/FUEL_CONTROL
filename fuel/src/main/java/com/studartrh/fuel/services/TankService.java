package com.studartrh.fuel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studartrh.fuel.dto.TankDTO;
import com.studartrh.fuel.entity.Tank;
import com.studartrh.fuel.repository.TankRepository;

@Service
public class TankService {
	@Autowired
	private TankRepository repository;
	
	public ResponseEntity<List<TankDTO> > getAll() {
	
		try {
			List<TankDTO> resp = repository.findAll().stream().map(TankDTO::new).toList();		
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public Tank findByFuel(String fuel) {
		return repository.findByFuel(fuel);
	}
}

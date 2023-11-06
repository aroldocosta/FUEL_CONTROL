package com.studartrh.fuel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.studartrh.fuel.dto.UserRequestDTO;
import com.studartrh.fuel.dto.UserDTO;
import com.studartrh.fuel.entity.User;
import com.studartrh.fuel.infra.security.SecurityConfiguration;
import com.studartrh.fuel.repository.UserRepository;

@Service
public class UserService {
	

	@Autowired
	private UserRepository repository;
	
	@Autowired
	SecurityConfiguration security;
	
	public ResponseEntity<List<UserDTO> > getAll() {
		
		try {
			List<UserDTO> resp = repository.findAll().stream().map(UserDTO::new).toList();
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public ResponseEntity<UserDTO> get(String id) {	
		
		try {
			UserDTO resp = repository.findById(id).stream().map(UserDTO::new).findAny().get();
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public ResponseEntity<UserDTO> save(UserDTO dto) {
		User user = new User(dto);
		String encryptedPass = security.passwordEncoder().encode(dto.password());
		user.setPassword(encryptedPass);
		UserDTO resp = new UserDTO(repository.save(user));	
		return ResponseEntity.ok(resp);		
	}
	
//	public ResponseEntity<UserDTO> update(UserDTO dto) {
//		User user = repository.findById(dto.id()).get().update(dto);
//		String encryptedPass = security.passwordEncoder().encode(dto.password());
//		user.setPassword(encryptedPass);
//		user.update(dto);
//		UserDTO resp = new UserDTO(repository.save(user));
//		return ResponseEntity.ok(resp);		
//	}
	
//	public ResponseEntity<UserDTO> delete(String id) {
//		
//		try {
//			User user = repository.findById(id).get();
//			repository.delete(user);
//			//return ResponseEntity.ok(new UserDTO("SUCCESS"));
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().build();
//		}
//	}

//	@Autowired
//	private UserRepository repository;
//	
//	@Autowired
//	SecurityConfiguration security;
//	
//	public ResponseEntity<List<UserDTO> > getAll() {
//		
//		try {
//			List<UserDTO> resp = repository.findAll().stream().map(UserDTO::new).toList();
//			return ResponseEntity.ok(resp);
//		} catch (Exception e) {
//			return ResponseEntity.noContent().build();
//		}
//	}
}

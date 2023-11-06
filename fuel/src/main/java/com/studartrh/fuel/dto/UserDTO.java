package com.studartrh.fuel.dto;

import com.studartrh.fuel.entity.User;
import com.studartrh.fuel.enums.UserRole;

public record UserDTO(String id, String name, String login, String password, UserRole role, String teste) {
	public UserDTO(User user) {
		this(
		user.getId(),		
		user.getName(), 
		user.getLogin(),
		user.getPassword(),
		user.getRole(), 
		"teste");
	}
}

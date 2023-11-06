package com.studartrh.fuel.enums;

public enum UserRole {
	ADMIN("admin"),
	OPERATOR("operator");
	
	private String role;
	
	private UserRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
}

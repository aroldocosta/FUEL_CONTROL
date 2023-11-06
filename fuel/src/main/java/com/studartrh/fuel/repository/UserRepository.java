package com.studartrh.fuel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.studartrh.fuel.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	public UserDetails findByLogin(String login);
}

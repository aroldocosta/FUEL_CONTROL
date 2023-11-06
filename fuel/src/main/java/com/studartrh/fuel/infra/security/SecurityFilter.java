package com.studartrh.fuel.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.studartrh.fuel.entity.User;
import com.studartrh.fuel.enums.UserRole;
import com.studartrh.fuel.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			
			var token = this.recoverToken(request);	
		
			if(token != null) {
				var login = tokenService.validateToken(token);
				UserDetails user = userRepository.findByLogin(login);
				
				if(login == null) {
					System.out.println("Usuario nulo");
					UserDetails admin = userRepository.findByLogin("admin@fuelcontrol.com");
					if(admin == null) {
						User adminUser = new User("Admin", "admin@fuelcontrol.com", "87654321", UserRole.ADMIN);
						userRepository.save(adminUser);
					}
					
					UserDetails oper = userRepository.findByLogin("oper@fuelcontrol.com");
					if(oper == null) {
						User operUser = new User("Operador", "oper@fuelcontrol.com", "87654321", UserRole.OPERATOR);
						userRepository.save(operUser);
					}
				}
				
				var authetication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authetication);
			}			
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		filterChain.doFilter(request, response);
	}
	
	private String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		
		if(authHeader == null) return null;
		return authHeader.replace("Bearer ", "");
	}
}

package com.studartrh.fuel.infra.security;

import java.beans.Customizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.CrossOriginEmbedderPolicyHeaderWriter.CrossOriginEmbedderPolicy;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.config.Customizer.withDefaults;

//https://copyprogramming.com/howto/spring-boot-security-doesn-t-let-me-access-h2-console

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {
	@Autowired
	SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
	        .cors().and()
			.csrf(csrf -> csrf.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests((authz) -> authz	        		
        		.requestMatchers(AntPathRequestMatcher.antMatcher("/tanks")).permitAll() 
        		.requestMatchers(AntPathRequestMatcher.antMatcher("/users/*")).permitAll() 
        		.requestMatchers(AntPathRequestMatcher.antMatcher("/pumps")).permitAll()		
        		.requestMatchers(AntPathRequestMatcher.antMatcher("/fuelings")).permitAll()
        		.requestMatchers(AntPathRequestMatcher.antMatcher("/fuelings/*")).permitAll()
        		.requestMatchers(AntPathRequestMatcher.antMatcher("/auth/login")).permitAll()
        		.requestMatchers(AntPathRequestMatcher.antMatcher("/report")).permitAll()
        		.requestMatchers(AntPathRequestMatcher.antMatcher("/fuelings/totals")).permitAll()	
                .anyRequest().authenticated()
            )
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .httpBasic(withDefaults());
        return http.build();
    }

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	MvcRequestMatcher buildMatcher(HandlerMappingIntrospector introspector, String pattern, HttpMethod method) {
		MvcRequestMatcher matcher = new MvcRequestMatcher(introspector, pattern);
		matcher.setMethod(method);
		return matcher;
	}
}


/*
 * 
# datasource
spring.datasource.url=jdbc:h2:mem:fuel_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=87654321

# h2
spring.h2.console.enabled=true
spring.h2.console.path=/h2

# jpa
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true

# security
api.security.token.secret=${JWT_SECRET:system-secret-key}
 */
 
  

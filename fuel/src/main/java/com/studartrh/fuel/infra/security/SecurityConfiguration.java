package com.studartrh.fuel.infra.security;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

//https://copyprogramming.com/howto/spring-boot-security-doesn-t-let-me-access-h2-console

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {
	@Autowired
	SecurityFilter securityFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
        	.cors().and()
			.csrf(csrf -> csrf.disable())
        	.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests((authz) -> authz
        		.requestMatchers(antMatcher(HttpMethod.GET, 	"/pumps")).permitAll()
        		.requestMatchers(antMatcher(HttpMethod.GET, 	"/tanks")).permitAll()
        		.requestMatchers(antMatcher(HttpMethod.GET, 	"/fuelings")).permitAll()
        		.requestMatchers(antMatcher(HttpMethod.GET, 	"/fuelings/totals")).permitAll()
        		.requestMatchers(antMatcher(HttpMethod.GET, 	"/fuelings/report")).permitAll()
        		.requestMatchers(antMatcher(HttpMethod.POST, 	"/fuelings")).permitAll()
                .requestMatchers(antMatcher(HttpMethod.PUT, 	"/fuelings")).permitAll()
                .requestMatchers(antMatcher(HttpMethod.DELETE, 	"/fuelings")).permitAll()
                .requestMatchers(antMatcher(HttpMethod.GET, 	"/users")).permitAll()
                .requestMatchers(antMatcher(HttpMethod.POST, 	"/auth/login")).permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .httpBasic(withDefaults()).build();
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
 
  

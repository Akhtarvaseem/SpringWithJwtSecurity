package com.springSecurityWithJWT.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springSecurityWithJWT.securityAuthentication.JwtAuthenticationFilter;
import com.springSecurityWithJWT.securityAuthentication.SecurityAuthenticationEntryPoint;

@Configuration
public class SecuriyConfig {
	
	@Autowired
	JwtAuthenticationFilter filter;
	
	@Autowired
	 SecurityAuthenticationEntryPoint entryPoint;
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf->csrf.disable())
		.cors(cors->cors.disable())
		.authorizeHttpRequests(
				authorize -> authorize
				.requestMatchers("/Employee/**").authenticated()
				.requestMatchers("/auth/login").permitAll()
				.anyRequest().authenticated()
				
				)
		.exceptionHandling(ex->ex.authenticationEntryPoint(entryPoint))
		.sessionManagement(sesstion->sesstion.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		
		.formLogin(formLogin -> formLogin
                .permitAll()  
            );
		http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}

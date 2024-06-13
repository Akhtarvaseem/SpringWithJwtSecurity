package com.springSecurityWithJWT.securityAuthentication;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// JWT implementation class  , its used to check valid user or not other wise throw error

@Component
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		
		// by Durgash 
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer=response.getWriter();
		
		writer.println("Authentication error "+authException.getMessage());
		
		
		// By Java guides (text)
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
		
	}
	
	

}

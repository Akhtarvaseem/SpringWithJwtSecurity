package com.springSecurityWithJWT.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurityWithJWT.model.Employee;
import com.springSecurityWithJWT.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	
	@Autowired
	EmployeeService service;
	
	
	@GetMapping("/get")
	public List<Employee> getyAllDetails(){
		
		return service.getAllDetails();
	}
	
	@GetMapping("/getName")
	public String getLoggig(Principal principal) {
		return principal.getName();
		
	}
	
}

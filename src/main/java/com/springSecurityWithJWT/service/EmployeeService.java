package com.springSecurityWithJWT.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springSecurityWithJWT.model.Employee;

@Service
public class EmployeeService {

	
	List<Employee> ls=new ArrayList<>();
	
	public EmployeeService() {
		Employee em1=new Employee(101,"rahul","rahul@dev.com");
		Employee em2=new Employee(102,"mukesh","mukesh@dev.com");
		Employee em3=new Employee(103,"dhiraj","dhiraj@dev.com");
		Employee em4=new Employee(104,"perkash","perkash@dev.com");
		ls.add(em1);
		ls.add(em2);
		ls.add(em3);
		ls.add(em4);
		
	}
	
	
	public List<Employee> getAllDetails(){
		
		System.out.println("in side get All ");
		return ls;
	}
}

package com.batch2.restclient;

import org.springframework.web.client.RestTemplate;

import com.batch2.model.Employee;

public class RestClient {
	
	
	public static Employee getEmployeeFromRestServiceById(Long id) {
		
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject("http://localhost:8080/employeeservice-1.0/employees/" + id, Employee.class, id);
		return employee;
	}
	
}

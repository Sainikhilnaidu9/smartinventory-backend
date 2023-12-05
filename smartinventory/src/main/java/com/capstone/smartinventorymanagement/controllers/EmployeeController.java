package com.capstone.smartinventorymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dtos.EmployeeDto;
import com.capstone.smartinventorymanagement.entity.Employee;
import com.capstone.smartinventorymanagement.services.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Component
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<EmployeeDto> findAll(){
		return employeeService.fetchAllEmployees();
	}
	@PostMapping("/employee")
	public void createEmployee(@RequestBody Employee employee)
	{
		employeeService.createEmployee(employee);
	}

	
}

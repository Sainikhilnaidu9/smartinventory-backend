package com.capstone.smartinventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dto.EmployeeDto;
import com.capstone.smartinventorymanagement.model.Employee;
import com.capstone.smartinventorymanagement.service.EmployeeService;



@RestController
@RequestMapping("/employeeControllerapi")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/employee")
	public List<EmployeeDto> findAll(){
		return employeeService.fetchAllEmployees();
	}
	@GetMapping("/employees/{employeeId}")
	public EmployeeDto findById(@PathVariable("employeeId")String employeeId)
	{
		return employeeService.fetchById(employeeId);
	}
	@PostMapping("/employee")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee)
	{
		String message =employeeService.createEmployee(employee);
		ResponseEntity<String> re = new ResponseEntity<String>(message,HttpStatus.CREATED);
		return re;
	}
	@PutMapping("employee/{employeeId}")
	public String updateEmployee(@RequestBody Employee employee,@PathVariable("employeeId")String employeeId)
	{
		return employeeService.updateEmployee(employee,employeeId);
	}
	@DeleteMapping("employee/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId")String employeeId)
	{
		return employeeService.deleteEmployee(employeeId);
	}
	
	
	

	
}

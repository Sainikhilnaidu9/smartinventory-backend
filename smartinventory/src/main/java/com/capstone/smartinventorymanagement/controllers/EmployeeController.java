package com.capstone.smartinventorymanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dtos.EmployeeDto;
import com.capstone.smartinventorymanagement.entity.Employee;
import com.capstone.smartinventorymanagement.mappers.EmployeeMapper;
import com.capstone.smartinventorymanagement.repositories.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<EmployeeDto> findAll(){
		List<Employee>employeeList = employeeRepository.findAll();
		List<EmployeeDto>employeeDtoList = new ArrayList<>();
		for (Employee employee : employeeList)
		{
			EmployeeDto employeeDto = EmployeeMapper.convertToDto(employee);
			employeeDtoList.add(employeeDto);
		}
		return employeeDtoList;
	}

	
}

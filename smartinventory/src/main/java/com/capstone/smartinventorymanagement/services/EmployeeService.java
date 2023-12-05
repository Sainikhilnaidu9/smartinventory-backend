package com.capstone.smartinventorymanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dtos.EmployeeDto;
import com.capstone.smartinventorymanagement.entity.Employee;
import com.capstone.smartinventorymanagement.mappers.EmployeeMapper;
import com.capstone.smartinventorymanagement.repositories.EmployeeRepository;

@Service
public class EmployeeService {
//	@Autowired
	EmployeeRepository employeeRepository;

	public List<EmployeeDto> fetchAllEmployees() {
		List<Employee>employeeList = employeeRepository.findAll();
		List<EmployeeDto>employeeDtoList = new ArrayList<>();
		for (Employee employee : employeeList)
		{
			EmployeeDto employeeDto = EmployeeMapper.convertToDto(employee);
			employeeDtoList.add(employeeDto);
		}
		return employeeDtoList;
	}

	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	

}

package com.capstone.smartinventorymanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dto.EmployeeDto;
import com.capstone.smartinventorymanagement.exception.EmployeeIdNotFoundException;
import com.capstone.smartinventorymanagement.mapper.EmployeeMapper;
import com.capstone.smartinventorymanagement.model.Employee;
import com.capstone.smartinventorymanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}

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

	public String createEmployee(Employee employee) {
		
		Employee empDb = employeeRepository.save(employee);
		if(empDb!=null)
			return "Inserted";
		else 
			return null;
	}

	public EmployeeDto fetchById(String employeeId) {
		Optional<Employee> emp = employeeRepository.findById(employeeId);
		if(emp.isPresent())
		{
			EmployeeDto employeeDto = EmployeeMapper.convertToDto(emp.get());
			return employeeDto;
		}
		else
			throw new EmployeeIdNotFoundException("No Employee found with Id: "+employeeId);
	}

	public String updateEmployee(Employee employee, String employeeId) {
		if(employeeRepository.existsById(employeeId))
		{
			Employee empDb = employeeRepository.save(employee);
			if(empDb!=null)
				return "Updated";
			else
				return null;
		}
		else
			throw new EmployeeIdNotFoundException("No Employee found with Id: "+employeeId);
	}

	public String deleteEmployee(String employeeId) {
		if(employeeRepository.existsById(employeeId))
		{
			employeeRepository.deleteById(employeeId);
			return "Deleted";
		}
		else
			throw new EmployeeIdNotFoundException("No Employee found with Id: "+employeeId);
	}
	
	
	

}

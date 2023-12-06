package com.capstone.smartinventorymanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dtos.EmployeeDto;
import com.capstone.smartinventorymanagement.entity.Employee;
import com.capstone.smartinventorymanagement.exceptions.EmployeeIdNotFoundException;
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

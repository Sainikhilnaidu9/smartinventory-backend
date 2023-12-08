package com.capstone.smartinventorymanagement.mapper;

import com.capstone.smartinventorymanagement.dto.EmployeeDto;
import com.capstone.smartinventorymanagement.model.Employee;

public class EmployeeMapper {
	public static EmployeeDto convertToDto(Employee employee){
		EmployeeDto employeeDto =new EmployeeDto();
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setRole(employee.getRole());
		return employeeDto;
	}
}

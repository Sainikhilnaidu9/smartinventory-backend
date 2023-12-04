package com.capstone.smartinventorymanagement.mappers;

import com.capstone.smartinventorymanagement.dtos.EmployeeDto;
import com.capstone.smartinventorymanagement.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto convertToDto(Employee employee){
		EmployeeDto employeeDto =new EmployeeDto();
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setRole(employee.getRole());
		return employeeDto;
	}
}

package com.capstone.smartinventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capstone.smartinventorymanagement.dto.EmployeeDto;
import com.capstone.smartinventorymanagement.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	
	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	private EmployeeService employeeService;
	
	@Test
	public void getAllEmployeesTest() throws Exception{
		EmployeeDto dto = new EmployeeDto();
		dto.setEmployeeId("INCUSER101");
		dto.setEmployeeName("Abcd");
		dto.setRole("Manager");
		
		List<EmployeeDto> list = new ArrayList<EmployeeDto>();
		list.add(dto);
		Mockito.when(employeeService.fetchAllEmployees()).thenReturn(list);
		List<EmployeeDto> employeeDto =employeeController.findAll();
		assertEquals(employeeDto, list);
		
	}

}

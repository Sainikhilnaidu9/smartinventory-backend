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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capstone.smartinventorymanagement.dto.EmployeeDto;
import com.capstone.smartinventorymanagement.model.Employee;
import com.capstone.smartinventorymanagement.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Test
    public void getAllEmployeesTest() {
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployeeId("INCUSER101");
        dto.setEmployeeName("Abcd");
        dto.setRole("Manager");

        List<EmployeeDto> list = new ArrayList<>();
        list.add(dto);
        Mockito.when(employeeService.fetchAllEmployees()).thenReturn(list);

        List<EmployeeDto> employeeDtoList = employeeController.findAll();
        assertEquals(employeeDtoList, list);
    }

    @Test
    public void getEmployeeByIdTest() {
        String employeeId = "INCUSER101";
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployeeId(employeeId);
        dto.setEmployeeName("Abcd");
        dto.setRole("Manager");

        Mockito.when(employeeService.fetchById(employeeId)).thenReturn(dto);

        EmployeeDto resultDto = employeeController.findById(employeeId);
        assertEquals(resultDto, dto);
    }

    @Test
    public void createEmployeeTest() {
        Employee employee = new Employee();
        employee.setEmployeeName("John Doe");
        employee.setRole("Developer");

        Mockito.when(employeeService.createEmployee(employee)).thenReturn("Employee created successfully");

        ResponseEntity<String> response = employeeController.createEmployee(employee);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), "Employee created successfully");
    }

    @Test
    public void updateEmployeeTest() {
        String employeeId = "INCUSER101";
        Employee employee = new Employee();
        employee.setEmployeeName("Updated Name");
        employee.setRole("Updated Role");

        Mockito.when(employeeService.updateEmployee(employee, employeeId)).thenReturn("Employee updated successfully");

        String resultMessage = employeeController.updateEmployee(employee, employeeId);
        assertEquals(resultMessage, "Employee updated successfully");
    }

    @Test
    public void deleteEmployeeTest() {
        String employeeId = "INCUSER101";
        Mockito.when(employeeService.deleteEmployee(employeeId)).thenReturn("Employee deleted successfully");

        String resultMessage = employeeController.deleteEmployee(employeeId);
        assertEquals(resultMessage, "Employee deleted successfully");
    }

    
}
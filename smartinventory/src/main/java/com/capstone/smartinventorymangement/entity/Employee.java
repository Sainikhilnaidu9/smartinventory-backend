package com.capstone.smartinventorymangement.entity;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee extends BaseAuditEntity {

	private final AtomicInteger counter = new AtomicInteger(100);
	@Id
	private String employeeId;
    private String employeeName;
    private String role;
    private String password;

    
    public Employee(String employeeName){
    	this.employeeName = employeeName;
    	this.employeeId = generateEmployeeId();
    }
    public String generateEmployeeId() {
    	return "INCUSR" + counter.incrementAndGet();
    }
    
	public String getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", role=" + role
				+ ", password=" + password + "]";
	}

    
}

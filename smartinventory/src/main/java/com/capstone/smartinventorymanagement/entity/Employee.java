package com.capstone.smartinventorymanagement.entity;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table
public class Employee extends BaseAuditEntity {

	private final AtomicInteger counter = new AtomicInteger(100);
	@Id
	@Column
	private String employeeId;
	@Column
    private String employeeName;
	@Column
    private String role;
	@Column
    private String password;

    
    public Employee(){
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

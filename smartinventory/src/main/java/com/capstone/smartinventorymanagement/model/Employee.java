package com.capstone.smartinventorymanagement.model;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee() {
		this.employeeId = setEmployeeId();
	}

	public String setEmployeeId() {
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

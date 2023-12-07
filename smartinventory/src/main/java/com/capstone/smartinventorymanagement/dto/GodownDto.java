package com.capstone.smartinventorymanagement.dto;

import java.time.LocalDate;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class GodownDto {
	private String godownId;
	private String location;
	private String name;
	@Temporal(TemporalType.DATE)
    private LocalDate startDate;
	public String getGodownId() {
		return godownId;
	}
	public void setGodownId(String godownId) {
		this.godownId = godownId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	
	// not added manager in dto 
	
	
	

}

package com.capstone.smartinventorymangement.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "godown")
public class Godown {
	private static final AtomicInteger counter = new AtomicInteger(100);
    @Id
    private String godownId;
    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;
    @OneToOne(optional = false)
    @JoinColumn(name = "employee_id", unique = true)
    private Employee manager;
    
    public Godown() {
    	this.godownId = generateGodownId();
    }
    public String generateGodownId() {
    	return "GDWN" + counter.incrementAndGet();
    }
	public String getGodownId() {
		return godownId;
	}
	public void setGodownId(String godownId) {
		this.godownId = godownId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Godown [godownId=" + godownId + ", name=" + name + ", location=" + location + ", startDate=" + startDate
				+ ", manager=" + manager + "]";
	}
	
	
    
}

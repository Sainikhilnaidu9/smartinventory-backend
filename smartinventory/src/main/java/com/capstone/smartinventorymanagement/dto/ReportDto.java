package com.capstone.smartinventorymanagement.dto;


public class ReportDto {
	private int reportId;
	private String month;
	private String location;
	private int itemReceived;
	private int itemdelivered;
	private int itemsReturned;
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getItemReceived() {
		return itemReceived;
	}
	public void setItemReceived(int itemReceived) {
		this.itemReceived = itemReceived;
	}
	public int getItemdelivered() {
		return itemdelivered;
	}
	public void setItemdelivered(int itemdelivered) {
		this.itemdelivered = itemdelivered;
	}
	public int getItemsReturned() {
		return itemsReturned;
	}
	public void setItemsReturned(int itemsReturned) {
		this.itemsReturned = itemsReturned;
	}
	
	

}

package com.capstone.smartinventorymanagement.dto;

import java.time.LocalDate;

public class ReturnDto {
	private int returnId;
	private String itemName;
	private LocalDate dateOfReturn;
	private int returnQuantity;
	private String checkedBy;
	private String returnReason;
	public int getReturnId() {
		return returnId;
	}
	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public LocalDate getDateOfReturn() {
		return dateOfReturn;
	}
	public void setDateOfReturn(LocalDate dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}
	public int getReturnQuantity() {
		return returnQuantity;
	}
	public void setReturnQuantity(int returnQuantity) {
		this.returnQuantity = returnQuantity;
	}
	public String getCheckedBy() {
		return checkedBy;
	}
	public void setCheckedBy(String checkedBy) {
		this.checkedBy = checkedBy;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	
	

}

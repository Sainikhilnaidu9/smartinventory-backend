package com.capstone.smartinventorymanagement.dto;

import java.time.LocalDate;

import com.capstone.smartinventorymanagement.model.Godown;

public class InwardItemDto {
	private String id;
	private Godown godown;
	private String nameOfSupplier;
	private LocalDate dateOfSupply;
	private String itemName;
	private double invoiceNumber;
	private String recievedBy;
	private String billCheckedBy;
	private double recieptNo;
	private Integer quantity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Godown getGodown() {
		return godown;
	}
	public void setGodown(Godown godown) {
		this.godown = godown;
	}
	public String getNameOfSupplier() {
		return nameOfSupplier;
	}
	public void setNameOfSupplier(String nameOfSupplier) {
		this.nameOfSupplier = nameOfSupplier;
	}
	public LocalDate getDateOfSupply() {
		return dateOfSupply;
	}
	public void setDateOfSupply(LocalDate dateOfSupply) {
		this.dateOfSupply = dateOfSupply;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(double invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getRecievedBy() {
		return recievedBy;
	}
	public void setRecievedBy(String recievedBy) {
		this.recievedBy = recievedBy;
	}
	public String getBillCheckedBy() {
		return billCheckedBy;
	}
	public void setBillCheckedBy(String billCheckedBy) {
		this.billCheckedBy = billCheckedBy;
	}
	public double getRecieptNo() {
		return recieptNo;
	}
	public void setRecieptNo(double recieptNo) {
		this.recieptNo = recieptNo;
	}
	
	

}

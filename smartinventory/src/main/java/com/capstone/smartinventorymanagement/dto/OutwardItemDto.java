package com.capstone.smartinventorymanagement.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.capstone.smartinventorymanagement.model.Godown;

public class OutwardItemDto {
	private String id;
    private Godown godown;
    private String itemName;
    private int invoiceNumber;
    private LocalDate outwardDate;
    private LocalDate deliveryDate;
    private String deliverTo;
    private double quantity;
    private String purpose;
    private int recieptNo;
    private int billValue;
    private String billCheckedBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Godown getGodown() {
		return godown;
	}
	public void setGodown(Godown godown) {
		this.godown = godown;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public LocalDate getOutwardDate() {
		return outwardDate;
	}
	public void setOutwardDate(LocalDate outwardDate) {
		this.outwardDate = outwardDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliverTo() {
		return deliverTo;
	}
	public void setDeliverTo(String deliverTo) {
		this.deliverTo = deliverTo;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String isPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getRecieptNo() {
		return recieptNo;
	}
	public void setRecieptNo(int recieptNo) {
		this.recieptNo = recieptNo;
	}
	public int getBillValue() {
		return billValue;
	}
	public void setBillValue(int billValue) {
		this.billValue = billValue;
	}
	public String getBillCheckedBy() {
		return billCheckedBy;
	}
	public void setBillCheckedBy(String billCheckedBy) {
		this.billCheckedBy = billCheckedBy;
	}
    
    

}

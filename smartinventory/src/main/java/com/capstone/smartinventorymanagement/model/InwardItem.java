package com.capstone.smartinventorymanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inward_items")
public class InwardItem extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;
    

  public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// we have to do many to one mapping here with Godown entity.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "godown_id")
    private Godown godown;

    @Column(name = "name_of_supplier", nullable = false)
    private String nameOfSupplier;

    @Column(name = "date_of_supply", nullable = false)
    private LocalDate dateOfSupply;
    
    @Column(name = "item_name", nullable = false)
    private String itemName;
    @Column(name ="quantity")
    private Integer quantity;
    
    public Integer getQuantity() {
		return quantity;
	}

	public Godown getGodown() {
		return godown;
	}

	public void setGodown(Godown godown) {
		this.godown = godown;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "invoice_number")
    private double invoiceNumber;

    @Column(name = "recieved_by")
    private String recievedBy;

    @Column(name = "bill_checked_by")
    private String billCheckedBy;

    @Column(name = "reciept_no")
    private double recieptNo;


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

    // Getters and setters
}
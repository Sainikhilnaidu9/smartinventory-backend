package com.capstone.smartinventorymanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "outward_items")
public class OutwardItem extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, length = 3)
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "godown_id")
    private Godown godown;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "invoice_number", nullable = false)
    private int invoiceNumber;
    
    @OneToOne
    @JoinColumn(name ="item_id")
    private Stock Item;

    @Column(name = "outward_date", nullable = false)
    private LocalDate outwardDate;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @Column(name = "deliver_to", nullable = false)
    private String deliverTo;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    
    //purpose is boolean bcoz as per doc, there are only two options.
    // 1=sale
    // 0 = service
    @Column(name = "purpose", nullable = false)
    private String purpose;

    @Column(name = "reciept_no", nullable = false)
    private int recieptNo;

    @Column(name = "bill_value", nullable = false)
    private int billValue;

    @Column(name = "bill_checked_by", nullable = false)
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

	public String getPurpose() {
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

    // Getters and setters
}
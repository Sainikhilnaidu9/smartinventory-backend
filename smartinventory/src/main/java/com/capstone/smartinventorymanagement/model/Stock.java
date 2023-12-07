package com.capstone.smartinventorymanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", nullable = false, unique = true, length = 3)
    private int itemId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_price", nullable = false)
    private int itemPrice;

    @Column(name = "item_quantity", nullable = false)
    private int itemQuantity;
    

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

    // Getters and setters
}

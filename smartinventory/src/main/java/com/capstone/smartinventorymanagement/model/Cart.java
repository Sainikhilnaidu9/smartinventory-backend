package com.capstone.smartinventorymanagement.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart extends BaseAuditEntity{
	@Id
	@GeneratedValue
	private int cartId;
	@Column
	@OneToMany(cascade= CascadeType.ALL)
	private List<Stock>listOfItems= new ArrayList<Stock>();
	@Column
	private int countOfItems;
	@Column
	private int totalPriceOfItems;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<Stock> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<Stock> listOfItems) {
		this.listOfItems = listOfItems;
	}
	public int getCountOfItems() {
		return countOfItems;
	}
	public void setCountOfItems(int countOfItems) {
		this.countOfItems = countOfItems;
	}
	public int getTotalPriceOfItems() {
		return totalPriceOfItems;
	}
	public void setTotalPriceOfItems(int totalPriceOfItems) {
		this.totalPriceOfItems = totalPriceOfItems;
	}
	
	
	
	
	
}

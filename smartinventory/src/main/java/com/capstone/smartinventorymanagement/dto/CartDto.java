package com.capstone.smartinventorymanagement.dto;

import java.util.ArrayList;
import java.util.List;

import com.capstone.smartinventorymanagement.model.Stock;

public class CartDto {
	private int cartId;
	private List<Stock>listOfItems= new ArrayList<Stock>();
	private int countOfItems;
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
	@Override
	public String toString() {
		return "CartDto [cartId=" + cartId + ", listOfItems=" + listOfItems + ", countOfItems=" + countOfItems
				+ ", totalPriceOfItems=" + totalPriceOfItems + "]";
	}
	
}

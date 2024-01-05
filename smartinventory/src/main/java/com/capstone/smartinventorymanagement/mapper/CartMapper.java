package com.capstone.smartinventorymanagement.mapper;

import com.capstone.smartinventorymanagement.dto.CartDto;
import com.capstone.smartinventorymanagement.model.Cart;

public class CartMapper {

	public static CartDto convertToDto(Cart cart) {
		CartDto cartDto=new CartDto();
		cartDto.setCartId(cart.getCartId());
		cartDto.setListOfItems(cart.getListOfItems());
		cartDto.setCountOfItems(cart.getCountOfItems());
		cartDto.setTotalPriceOfItems(cart.getTotalPriceOfItems());
		return cartDto;
	}

}

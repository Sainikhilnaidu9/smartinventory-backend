package com.capstone.smartinventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capstone.smartinventorymanagement.dto.CartDto;
import com.capstone.smartinventorymanagement.service.CartService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {
	
	@InjectMocks
	CartController cartController;
	
	@Mock
	private CartService cartService;
	
	@Test
	public void getAllCartsTest() throws Exception{
		CartDto dto = new CartDto();
		dto.setCartId(17);
		dto.setListOfItems(null);
		dto.setCountOfItems(23);
		dto.setTotalPriceOfItems(47);
		List<CartDto> list = new ArrayList<CartDto>();
		list.add(dto);
		Mockito.when(cartService.findAllcartDetails()).thenReturn(list);
		List<CartDto> cartDto =cartController.getAllCartDetails();
		assertEquals(cartDto, list);
		
	}

}

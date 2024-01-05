package com.capstone.smartinventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dto.CartDto;
import com.capstone.smartinventorymanagement.model.Cart;
import com.capstone.smartinventorymanagement.service.CartService;

@RestController
public class CartController {
	@Autowired
	CartService cartService;
	
	@GetMapping("/carts")
	public List<CartDto> getAllCartDetails(){
		return cartService.findAllcartDetails();
	}
	
	@GetMapping("/carts/{id}")
	public CartDto getCartDetailsById(@PathVariable("id") Integer id) {
		return cartService.findCartDetailsById(id);
		
	}
	
	@PostMapping("/carts")
	public String postCartDetails(@RequestBody Cart cart) {
		return cartService.insertCartDetails(cart);
	}
	
	@PutMapping("/carts/{id}")
	public String putCartDetails(@RequestBody Cart cart,@PathVariable("id") Integer id) {
		return cartService.updateCartDetails(cart,id);
	}
	
	@DeleteMapping("/carts/{id}")
	public String removeCartDetails(@PathVariable("id") Integer id) {
		return cartService.deleteCartDetails(id);
	}

}

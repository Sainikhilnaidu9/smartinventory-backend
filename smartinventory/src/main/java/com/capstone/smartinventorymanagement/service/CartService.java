package com.capstone.smartinventorymanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dto.CartDto;
import com.capstone.smartinventorymanagement.exception.CartIdNotFoundException;
import com.capstone.smartinventorymanagement.mapper.CartMapper;
import com.capstone.smartinventorymanagement.model.Cart;
import com.capstone.smartinventorymanagement.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	
	public List<CartDto> findAllcartDetails() {
		List<Cart>cartList=cartRepository.findAll();
		List<CartDto>cartDtoList=new ArrayList<>();
		for (Cart cart:cartList) {
			CartDto cartDto=CartMapper.convertToDto(cart);
			cartDtoList.add(cartDto);
		}
		return cartDtoList;
	}

	public CartDto findCartDetailsById(Integer id) {
		Optional<Cart> op=cartRepository.findById(id);
		if(op.isPresent()) {
            return CartMapper.convertToDto(op.get());
        } else {
            
            throw new CartIdNotFoundException("No Record is found for cart with id: " + id);
        }
	}

	public String insertCartDetails(Cart cart) {
		Cart isSaved=cartRepository.save(cart);
		if(isSaved==null) {
			return "Unable to Insert";
		}
		return "Cart Details inserted Successfully";
	}

	public String updateCartDetails(Cart cart, Integer id) {
		Optional<Cart> op=cartRepository.findById(id);
		if(op.isPresent()) {
			
			Cart isSaved=cartRepository.save(cart);
			if(isSaved==null) {
				return "Not updated due to some error";
			}else {
				return "updated successfully the details with id: "+id;
			}
		}else {
			throw new CartIdNotFoundException("No Record is found for cart with id: " + id);
		}
	}

	public String deleteCartDetails(Integer id) {
		if(cartRepository.existsById(id)) {
			cartRepository.deleteById(id);
			return "CartDetailsDeleted";
		}else {
			throw new CartIdNotFoundException("No Record is found for cart with id: " + id);
		}
	}

}

package com.capstone.smartinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	
}

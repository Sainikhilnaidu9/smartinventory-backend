package com.capstone.smartinventorymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dtos.OutwardItemDto;
import com.capstone.smartinventorymanagement.entity.OutwardItem;
import com.capstone.smartinventorymanagement.services.OutwardItemServices;

@RestController
public class OutwardItemController {
	@Autowired
	OutwardItemServices outwardItemServices;
	
	@GetMapping("/outwardItems")
	public List<OutwardItemDto> getAllOutwardItems(){
		return outwardItemServices.findAllOutwardItems();
	}
	
	@PostMapping("/outwardItems")
	public String postOutwardItem(@RequestBody OutwardItem outwardItem) {
		return outwardItemServices.insertOutwardItem(outwardItem);
	}

}

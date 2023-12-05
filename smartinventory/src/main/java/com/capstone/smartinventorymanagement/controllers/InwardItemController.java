package com.capstone.smartinventorymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dtos.InwardItemDto;
import com.capstone.smartinventorymanagement.entity.InwardItem;
import com.capstone.smartinventorymanagement.services.InwardItemServices;

@RestController
public class InwardItemController {
	@Autowired
	InwardItemServices inwardItemServices;
	
	@GetMapping("/inwardItems")
	public List<InwardItemDto> getAllInwardItems(){
		return inwardItemServices.findAllInwardItems();
	}
	
	@PostMapping("/inwardItems")
	public String postInwardItem(@RequestBody InwardItem inwardItem) {
		return inwardItemServices.insertInwardItem(inwardItem);
	}

}

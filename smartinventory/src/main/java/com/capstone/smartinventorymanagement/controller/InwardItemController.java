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

import com.capstone.smartinventorymanagement.dto.InwardItemDto;
import com.capstone.smartinventorymanagement.model.InwardItem;
import com.capstone.smartinventorymanagement.service.InwardItemServices;

@RestController
public class InwardItemController {
	@Autowired
	InwardItemServices inwardItemServices;
	
	@GetMapping("/inwardItems")
	public List<InwardItemDto> getAllInwardItems(){
		return inwardItemServices.findAllInwardItems();
	}
	
	@GetMapping("/inwardItems/{id}")
	public InwardItemDto getInwardItemById(@PathVariable("id") String id) {
		return inwardItemServices.findInwardItemById(id);
		
	}
	
	@PostMapping("/inwardItems")
	public String postInwardItem(@RequestBody InwardItem inwardItem) {
		return inwardItemServices.insertInwardItem(inwardItem);
	}
	
	@PutMapping("/inwardItems/{id}")
	public String putInwardItem(@RequestBody InwardItem inwardItem,@PathVariable("id") String id) {
		return inwardItemServices.updateInwardItem(inwardItem,id);
	}
	
	@DeleteMapping("/inwardItems/{id}")
	public String removeInwardItem(@PathVariable("id") String id) {
		return inwardItemServices.deleteInwardItem(id);
	}

}

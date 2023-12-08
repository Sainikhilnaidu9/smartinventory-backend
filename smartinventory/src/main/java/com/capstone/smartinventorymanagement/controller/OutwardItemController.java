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

import com.capstone.smartinventorymanagement.dto.OutwardItemDto;
import com.capstone.smartinventorymanagement.model.OutwardItem;
import com.capstone.smartinventorymanagement.service.OutwardItemServices;

@RestController
public class OutwardItemController {
	@Autowired
	OutwardItemServices outwardItemServices;
	
	@GetMapping("/outwardItems")
	public List<OutwardItemDto> getAllOutwardItems(){
		return outwardItemServices.findAllOutwardItems();
	}
	
	@GetMapping("/outwardItems/{id}")
	public OutwardItemDto getOutwardItemById(@PathVariable("id") String id) {
		return outwardItemServices.findOutwardItemById(id);
	}
	
	@PostMapping("/outwardItems")
	public String postOutwardItem(@RequestBody OutwardItem outwardItem) {
		return outwardItemServices.insertOutwardItem(outwardItem);
	}
	
	@PutMapping("/outwardItems/{id}")
	public String putOutwardItem(@RequestBody OutwardItem outwardItem,@PathVariable("id") String id) {
		return outwardItemServices.updateOutwardItem(outwardItem,id);
	}
	
	@DeleteMapping("/outwardItems/{id}")
	public String removeOutwardItem(@PathVariable("id") String id) {
		return outwardItemServices.deleteOutwardItem(id);
	}

}

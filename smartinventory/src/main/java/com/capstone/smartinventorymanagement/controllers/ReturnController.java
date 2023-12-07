package com.capstone.smartinventorymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dtos.InwardItemDto;
import com.capstone.smartinventorymanagement.dtos.ReturnDto;
import com.capstone.smartinventorymanagement.entity.InwardItem;
import com.capstone.smartinventorymanagement.entity.Return;
import com.capstone.smartinventorymanagement.services.ReturnService;

@RestController
public class ReturnController {
	@Autowired
	ReturnService returnService;
	
	@GetMapping("/returns")
	public List<ReturnDto> getAllReturns(){
		return returnService.fetchAllReturns();
	}
	
	@GetMapping("/return/{id}")
	public ReturnDto getReturnItemById(@PathVariable("id") String id) {
		return ((ReturnService) returnService).findReturnItemsById(id);
		
	}
	
	@PostMapping("/returnItems")
	public String postReturns(@RequestBody Return returns) {
		return ((ReturnService) returnService).insertReturn(returns);
	}
	
	@PutMapping("/return/{id}")
	public String putReturn(@RequestBody Return returns,@PathVariable("id") String id) {
		return returnService.updateReturn(returns,id);
	}
	
	@DeleteMapping("/returns/{id}")
	public String removeReturn(@PathVariable("id") String id) {
		return returnService.deleteReturn(id);
	}

	
}

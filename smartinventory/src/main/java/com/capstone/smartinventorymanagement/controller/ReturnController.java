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
import com.capstone.smartinventorymanagement.dto.ReturnDto;
import com.capstone.smartinventorymanagement.model.Return;
import com.capstone.smartinventorymanagement.service.ReturnService;


@RestController
public class ReturnController {
	@Autowired
	ReturnService returnService;
	
	@GetMapping("/returns")
	public List<ReturnDto> getAllReturns(){
		return returnService.fetchAllReturns();
	}
	
	@GetMapping("/returns/{id}")
	public ReturnDto getReturnItemById(@PathVariable("id") Integer id) {
		return ((ReturnService) returnService).findReturnItemsById(id);
		
	}
	
	@PostMapping("/returns")
	public String postReturns(@RequestBody Return returns) {
		return ((ReturnService) returnService).insertReturn(returns);
	}
	
	@PutMapping("/returns/{id}")
	public String putReturn(@RequestBody Return returns,@PathVariable("id") Integer id) {
		return returnService.updateReturn(returns,id);
	}
	
	@DeleteMapping("/returns/{id}")
	public String removeReturn(@PathVariable("id") Integer id) {
		return returnService.deleteReturn(id);
	}

	
}

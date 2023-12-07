package com.capstone.smartinventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dto.ReturnDto;
import com.capstone.smartinventorymanagement.service.ReturnService;

@RestController
public class ReturnController {
	@Autowired
	ReturnService returnService;
	
	@GetMapping("/returns")
	public List<ReturnDto> findAll(){
		
		
		return returnService.fetchAllReturns();
	}

	
}

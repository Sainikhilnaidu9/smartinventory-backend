package com.capstone.smartinventorymanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dtos.ReturnDto;
import com.capstone.smartinventorymanagement.entity.Return;
import com.capstone.smartinventorymanagement.mappers.ReturnMapper;
import com.capstone.smartinventorymanagement.repositories.ReturnRepository;
import com.capstone.smartinventorymanagement.services.ReturnService;

@RestController
public class ReturnController {
	@Autowired
	ReturnService returnService;
	
	@GetMapping("/returns")
	public List<ReturnDto> findAll(){
		
		
		return returnService.fetchAllReturns();
	}

	
}

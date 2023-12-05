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

@RestController
public class ReturnController {
	@Autowired
	ReturnRepository returnRepository;
	
	@GetMapping("/returns")
	public List<ReturnDto> findAll(){
		Return ret = new Return();
		List<Return>returnList = returnRepository.findAll();
		List<ReturnDto>returnDtoList = new ArrayList<>();
		for (Return returns : returnList)
		{
			ReturnDto returnDto = ReturnMapper.convertToDto(returns);
			returnDtoList.add(returnDto);
		}
		
		return returnDtoList;
	}

	
}

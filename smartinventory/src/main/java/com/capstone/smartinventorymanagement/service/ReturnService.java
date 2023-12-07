package com.capstone.smartinventorymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dto.ReturnDto;
import com.capstone.smartinventorymanagement.mapper.ReturnMapper;
import com.capstone.smartinventorymanagement.model.Return;
import com.capstone.smartinventorymanagement.repository.ReturnRepository;

@Service
public class ReturnService {
	ReturnRepository returnRepository;

	public List<ReturnDto> fetchAllReturns() {
		List<Return>returnList = returnRepository.findAll();
		List<ReturnDto>returnDtoList = new ArrayList<>();
		for (Return returnItem : returnList)
		{
			ReturnDto returnDto = ReturnMapper.convertToDto(returnItem);
			returnDtoList.add(returnDto);
		}
		return returnDtoList;
	}
	
	

}

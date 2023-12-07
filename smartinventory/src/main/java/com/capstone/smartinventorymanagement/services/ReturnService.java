package com.capstone.smartinventorymanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dtos.ReturnDto;
import com.capstone.smartinventorymanagement.entity.Return;
import com.capstone.smartinventorymanagement.mappers.ReturnMapper;
import com.capstone.smartinventorymanagement.repositories.ReturnRepository;

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

	public ReturnDto findReturnItemsById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertReturn(Return returns) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateReturn(Return returns, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteReturn(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}

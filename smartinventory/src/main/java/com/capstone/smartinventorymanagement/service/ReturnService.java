package com.capstone.smartinventorymanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dto.ReturnDto;
import com.capstone.smartinventorymanagement.exception.ReturnIdNotFoundException;
import com.capstone.smartinventorymanagement.mapper.ReturnMapper;
import com.capstone.smartinventorymanagement.model.Return;
import com.capstone.smartinventorymanagement.repository.ReturnRepository;


@Service
public class ReturnService {
	@Autowired
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

	public ReturnDto findReturnItemsById(Integer id) {
		Optional<Return> op = returnRepository.findById(id);
		if(op.isPresent())
		{
			ReturnDto returnDto = ReturnMapper.convertToDto(op.get());
			return returnDto;
		}
		else 
			throw new ReturnIdNotFoundException("No Record is found for Return with id: " + id);
	}

	public String insertReturn(Return returns) {
		Return isSaved=returnRepository.save(returns);
		if(isSaved==null) {
			return "Unable to Insert";
		}
		return "Return item inserted Successfully";
	}

	public String updateReturn(Return returns, Integer id) {
		Optional<Return> op=returnRepository.findById(id);
		if(op.isPresent()) {
			Return isSaved=returnRepository.save(returns);
			if(isSaved==null) {
				return "Not updated";
			}else {
				return "Updated successfully the details with id: {id}";
			}
		}else {
			throw new ReturnIdNotFoundException("No Record is found for Return with id: " + id);
		}
	}

	public String deleteReturn(Integer id) {
		if(returnRepository.existsById(id)) {
			returnRepository.deleteById(id);
			return "Deleted";
		}else {
			throw new ReturnIdNotFoundException("No Record is found for Return with id: " + id);
		}
	}
	

}

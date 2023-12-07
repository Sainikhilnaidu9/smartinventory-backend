package com.capstone.smartinventorymanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

<<<<<<< HEAD:smartinventory/src/main/java/com/capstone/smartinventorymanagement/service/ReturnService.java
import com.capstone.smartinventorymanagement.dto.ReturnDto;
import com.capstone.smartinventorymanagement.mapper.ReturnMapper;
import com.capstone.smartinventorymanagement.model.Return;
import com.capstone.smartinventorymanagement.repository.ReturnRepository;
=======
import com.capstone.smartinventorymanagement.dtos.ReturnDto;
import com.capstone.smartinventorymanagement.entity.Return;
import com.capstone.smartinventorymanagement.exceptions.ReturnIdNotFoundException;
import com.capstone.smartinventorymanagement.mappers.ReturnMapper;
import com.capstone.smartinventorymanagement.repositories.ReturnRepository;
>>>>>>> 26102eab6d8bf404f45b644404fc2bd8e15523a9:smartinventory/src/main/java/com/capstone/smartinventorymanagement/services/ReturnService.java

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

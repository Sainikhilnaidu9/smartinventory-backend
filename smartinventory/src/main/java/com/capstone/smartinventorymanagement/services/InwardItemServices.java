package com.capstone.smartinventorymanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dtos.InwardItemDto;
import com.capstone.smartinventorymanagement.entity.InwardItem;
import com.capstone.smartinventorymanagement.exceptions.GodownIdNotFoundException;
import com.capstone.smartinventorymanagement.exceptions.InwardItemIdNotFoundException;
import com.capstone.smartinventorymanagement.mappers.GodownMapper;
import com.capstone.smartinventorymanagement.mappers.InwardItemMapper;
import com.capstone.smartinventorymanagement.repositories.InwardItemRepository;

@Service
public class InwardItemServices {
//	@Autowired
	InwardItemRepository inwardItemRepository;

	public List<InwardItemDto> findAllInwardItems() {
		List<InwardItem>inwardItemList=inwardItemRepository.findAll();
		List<InwardItemDto>inwardItemDtoList=new ArrayList<>();
		for (InwardItem inwardItem:inwardItemList) {
			InwardItemDto inwardItemDto=InwardItemMapper.convertToDto(inwardItem);
			inwardItemDtoList.add(inwardItemDto);
		}
		return inwardItemDtoList;
	}

	public String insertInwardItem(InwardItem inwardItem) {
		InwardItem isSaved=inwardItemRepository.save(inwardItem);
		if(isSaved==null) {
			return "Unable to Insert";
		}
		return "Inward item inserted Successfully";
	}

	public InwardItemDto findInwardItemById(String id) {
		Optional<InwardItem> op=inwardItemRepository.findById(id);
		if(op.isPresent()) {
            return InwardItemMapper.convertToDto(op.get());
        } else {
            
            throw new InwardItemIdNotFoundException("No Record is found for InwardItem with id: " + id);
        }
	}

	public String updateInwardItem(InwardItem inwardItem, String id) {
		Optional<InwardItem> op=inwardItemRepository.findById(id);
		if(op.isPresent()) {
			InwardItem isSaved=inwardItemRepository.save(inwardItem);
			if(isSaved==null) {
				return "Not updated due to some error";
			}else {
				return "updated successfully the details with id: {id}";
			}
		}else {
			throw new InwardItemIdNotFoundException("No Record is found for InwardItem with id: " + id);
		}
	}

	public String deleteInwardItem(String id) {
		if(inwardItemRepository.existsById(id)) {
			inwardItemRepository.deleteById(id);
			return "InwardItemDeleted";
		}else {
			throw new InwardItemIdNotFoundException("No Record is found for InwardItem with id: " + id);
		}
	}

}

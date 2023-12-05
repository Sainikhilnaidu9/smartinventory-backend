package com.capstone.smartinventorymanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dtos.OutwardItemDto;
import com.capstone.smartinventorymanagement.entity.OutwardItem;
import com.capstone.smartinventorymanagement.mappers.OutwardItemMapper;
import com.capstone.smartinventorymanagement.repositories.OutwardItemRepository;

@Service
public class OutwardItemServices {
	@Autowired
	OutwardItemRepository outwardItemRepository;

	public List<OutwardItemDto> findAllOutwardItems() {
		List<OutwardItem> outwardItemList=outwardItemRepository.findAll();
		List<OutwardItemDto> outwardItemDtoList=new ArrayList<>();
		for(OutwardItem outwardItem:outwardItemList) {
			OutwardItemDto outwardItemDto=OutwardItemMapper.convertToDto(outwardItem);
			outwardItemDtoList.add(outwardItemDto);
		}
		return outwardItemDtoList;
	}

	public String insertOutwardItem(OutwardItem outwardItem) {
		outwardItemRepository.save(outwardItem);
		return "Outward Items inserted successfully";
	}
	
	
}

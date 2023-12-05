package com.capstone.smartinventorymanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dtos.InwardItemDto;
import com.capstone.smartinventorymanagement.entity.InwardItem;
import com.capstone.smartinventorymanagement.mappers.InwardItemMapper;
import com.capstone.smartinventorymanagement.repositories.InwardItemRepository;

@Service
public class InwardItemServices {
	@Autowired
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
		inwardItemRepository.save(inwardItem);
		return "Inward item inserted Successfully";
	}

}

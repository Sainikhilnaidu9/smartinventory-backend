package com.capstone.smartinventorymanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dtos.OutwardItemDto;
import com.capstone.smartinventorymanagement.entity.InwardItem;
import com.capstone.smartinventorymanagement.entity.OutwardItem;
import com.capstone.smartinventorymanagement.exceptions.InwardItemIdNotFoundException;
import com.capstone.smartinventorymanagement.exceptions.OutwardItemIdNotFoundException;
import com.capstone.smartinventorymanagement.mappers.InwardItemMapper;
import com.capstone.smartinventorymanagement.mappers.OutwardItemMapper;
import com.capstone.smartinventorymanagement.repositories.OutwardItemRepository;

@Service
public class OutwardItemServices {
//	@Autowired
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
		OutwardItem isSaved=outwardItemRepository.save(outwardItem);
		if(isSaved==null) {
			return "Not Insereted due to some error";
		}else {
		
		return "Outward Items inserted successfully";
		}
	}

	public OutwardItemDto findOutwardItemById(String id) {
		Optional<OutwardItem> op=outwardItemRepository.findById(id);
		if(op.isPresent()) {
            return OutwardItemMapper.convertToDto(op.get());
        } else {
            
            throw new OutwardItemIdNotFoundException("No Record is found for OutwardItem with id: " + id);
        }
		
	}

	public String updateOutwardItem(OutwardItem outwardItem, String id) {
		Optional<OutwardItem> op=outwardItemRepository.findById(id);
		if(op.isPresent()) {
			OutwardItem isSaved=outwardItemRepository.save(outwardItem);
			if(isSaved==null) {
				return "Not updated due to some error";
			}else {
				return "updated successfully the details with id: {id}";
			}
		}else {
			throw new OutwardItemIdNotFoundException("No Record is found for OutwardItem with id: " + id);
		}
	}

	public String deleteOutwardItem(String id) {
		if(outwardItemRepository.existsById(id)) {
			outwardItemRepository.deleteById(id);
			return "OutwardItem Deleted";
		}else {
			throw new OutwardItemIdNotFoundException("No Record is found for OutwardItem with id: " + id);
		}
	}
	
	
}

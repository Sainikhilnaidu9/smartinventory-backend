package com.capstone.smartinventorymanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dto.InwardItemDto;
import com.capstone.smartinventorymanagement.exception.GodownIdNotFoundException;
import com.capstone.smartinventorymanagement.exception.InwardItemIdNotFoundException;
import com.capstone.smartinventorymanagement.mapper.GodownMapper;
import com.capstone.smartinventorymanagement.mapper.InwardItemMapper;
import com.capstone.smartinventorymanagement.model.Godown;
import com.capstone.smartinventorymanagement.model.InwardItem;
import com.capstone.smartinventorymanagement.model.Stock;
import com.capstone.smartinventorymanagement.repository.GodownRepository;
import com.capstone.smartinventorymanagement.repository.InwardItemRepository;
import com.capstone.smartinventorymanagement.repository.StockRepository;

@Service
public class InwardItemServices {
	@Autowired
	InwardItemRepository inwardItemRepository;
	@Autowired
	StockRepository stockRepo;
	@Autowired
	GodownRepository godownRepo;

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
		Godown godown = godownRepo.findById(inwardItem.getGodown().getGodownId()).orElse(null);
        if (godown != null) {
        	updateGodownWithInwardItem(godown, inwardItem);
            // Update the Godown in the repository
            godownRepo.save(godown);
        }

		return "Inward item inserted Successfully";
	}
	 private void updateGodownWithInwardItem(Godown godown, InwardItem inwardItem) {
	        // Check if the item is already present in the Godown
	        Optional<Stock> existingStock = godown.getItems().stream()
	                .filter(stock -> stock.getItemName().equals(inwardItem.getItemName()))
	                .findFirst();

	        if (existingStock.isPresent()) {
	            // If the item is already present, update its quantity
	            Stock stockToUpdate = existingStock.get();
	            stockToUpdate.setItemQuantity(stockToUpdate.getItemQuantity() + inwardItem.getQuantity());
	        } else {
	            // If the item is not present, create a new Stock and add it to the Godown
	            Stock newStock = new Stock();
	            newStock.setItemName(inwardItem.getItemName());
	            newStock.setItemQuantity(inwardItem.getQuantity());
	            // Set other stock properties accordingly
	            // ...

	            godown.getItems().add(newStock);
	        }
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
				Godown godown = isSaved.getGodown();
				updateGodownWithInwardItem(godown, isSaved);
				return "updated successfully the details with id: {id}";
			}
		}else {
			throw new InwardItemIdNotFoundException("No Record is found for InwardItem with id: " + id);
		}
	}

	public String deleteInwardItem(String id) {
		if(inwardItemRepository.existsById(id)) {
			Optional<InwardItem> inward = inwardItemRepository.findById(id);
			InwardItem item = inward.get();
			Godown godown =item.getGodown();
			inwardItemRepository.deleteById(id);
			Optional<Stock> stockToDelete = godown.getItems().stream()
	                .filter(stock -> stock.getItemName().equals(item.getItemName()))
	                .findFirst();

	        stockToDelete.ifPresent(stock -> {
	            // Subtract the quantity of the deleted inward item from the stock
	            stock.setItemQuantity(stock.getItemQuantity() - item.getQuantity());

	            // Remove the stock if its quantity becomes zero
	            if (stock.getItemQuantity() <= 0) {
	                godown.getItems().remove(stock);
	            }
	        });
			return "InwardItemDeleted";
		}else {
			throw new InwardItemIdNotFoundException("No Record is found for InwardItem with id: " + id);
		}
	}

}

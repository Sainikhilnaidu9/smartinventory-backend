package com.capstone.smartinventorymanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dto.StockDto;
import com.capstone.smartinventorymanagement.exception.ItemIdNotFoundException;
import com.capstone.smartinventorymanagement.mapper.StockMapper;
import com.capstone.smartinventorymanagement.model.Stock;
import com.capstone.smartinventorymanagement.repository.StockRepository;


	

@Service
public class StockServices {
//
    @Autowired
    private StockRepository stockRepository;

    public List<StockDto> getAllItems() {
        List<Stock> stocks = stockRepository.findAll();
        List<StockDto> stockDtos = new ArrayList<>();

        for (Stock stock : stocks) {
            stockDtos.add(StockMapper.convertToDto(stock));
        }

        return stockDtos;
    }


    public StockDto getItemById(int id) {
        Optional<Stock> op = stockRepository.findById(id);
        
        if(op.isPresent()) {
            System.out.println("Item found");
            return StockMapper.convertToDto(op.get());
        } else {
            
            throw new ItemIdNotFoundException("No Record found for Item with id: " + id);
        }
    }

	public String createItem(StockDto stockDto) {
	    Stock stock = new Stock();
	    stock.setItemId(stockDto.getItemId());
	    stock.setItemName(stockDto.getItemName());
	    stock.setItemPrice(stockDto.getItemPrice());
	    stock.setItemQuantity(stockDto.getItemQuantity());

	    StockDto stockDB= StockMapper.convertToDto(stockRepository.save(stock));
	    
	    if(stockDB!=null) {
	    	return "Created";
	    			
	    }
	    else {
	    	return null;
	    }
	}
	
	
	

	
	
	public String updateItem(int id, StockDto stockDto) {
	    Optional<Stock> optionalStock = stockRepository.findById(id);
	    if (optionalStock.isPresent()) {
	        Stock stock = optionalStock.get();
	        stock.setItemId(stockDto.getItemId());
	        stock.setItemName(stockDto.getItemName());
	        stock.setItemPrice(stockDto.getItemPrice());
	        stock.setItemQuantity(stockDto.getItemQuantity());

	        StockDto StockDB=StockMapper.convertToDto(stockRepository.save(stock));
	        if(StockDB!=null) {
	        	return "Updated";
	        }
	        else {
	        	return null;
	        }
	    }else {
	    	throw new ItemIdNotFoundException("No Record found for Item with id: " + id);
	    }
	}
	
	
	
    

    public String deleteItem(int id) {
    	if(stockRepository.existsById(id)) {
    		stockRepository.deleteById(id);
    		return "Deleted";
    	}
    	else {
    		throw new ItemIdNotFoundException("No Record found for Item with id: " + id);
    	}
        
    }
}



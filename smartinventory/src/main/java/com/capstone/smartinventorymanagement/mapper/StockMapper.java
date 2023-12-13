package com.capstone.smartinventorymanagement.mapper;
import com.capstone.smartinventorymanagement.dto.StockDto;
import com.capstone.smartinventorymanagement.model.Stock;

public class StockMapper {
	public static StockDto convertToDto(Stock stock) {
		StockDto stockDto=new StockDto();
		stockDto.setItemId(stock.getItemId());
		stockDto.setItemName(stock.getItemName());
		stockDto.setItemPrice(stock.getItemPrice());
		stockDto.setItemQuantity(stock.getItemQuantity());
		
		return stockDto;
	}

}

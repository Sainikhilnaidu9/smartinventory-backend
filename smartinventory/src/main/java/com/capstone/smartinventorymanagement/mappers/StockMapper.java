package com.capstone.smartinventorymanagement.mappers;
import com.capstone.smartinventorymanagement.dtos.StockDto;
import com.capstone.smartinventorymanagement.entity.Stock;

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

package com.capstone.smartinventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capstone.smartinventorymanagement.dto.StockDto;
import com.capstone.smartinventorymanagement.service.StockServices;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class StockControllerTest {
	
	@InjectMocks
	StockController stockController;
	
	@Mock
	private StockServices stockServices;
	
	@Test
	public void getAllStocksTest() throws Exception{
		StockDto dto = new StockDto();
		dto.setItemId(1234);
		dto.setItemName("Abcd");
		dto.setItemPrice(12347);
		dto.setItemQuantity(13);
		List<StockDto> list = new ArrayList<StockDto>();
		list.add(dto);
		Mockito.when(stockServices.getAllItems()).thenReturn(list);
		List<StockDto> godownDto =stockController.getAllItems();
		assertEquals(godownDto, list);
		
	}

}

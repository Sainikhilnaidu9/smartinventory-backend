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

import com.capstone.smartinventorymanagement.dto.InwardItemDto;
import com.capstone.smartinventorymanagement.service.InwardItemServices;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class InwardItemTest {
	
	@InjectMocks
	InwardItemController inwardItemController;
	
	@Mock
	private InwardItemServices inwardItemServices;
	
	@Test
	public void getAllInwardItemsTest() throws Exception{
		InwardItemDto dto = new InwardItemDto();
		dto.setId(1234);
		dto.setNameOfSupplier("Abc");
		dto.setItemName("Abcd");
		dto.setInvoiceNumber(12361547);
		dto.setRecievedBy("Abcd");
		dto.setBillCheckedBy("Abcd");
		dto.setRecieptNo(63422342);
		dto.setQuantity(13);
		List<InwardItemDto> list = new ArrayList<InwardItemDto>();
		list.add(dto);
		Mockito.when(inwardItemServices.findAllInwardItems()).thenReturn(list);
		List<InwardItemDto> InwardItemsDto =inwardItemController.getAllInwardItems();
		assertEquals(InwardItemsDto, list);
		
	}

}

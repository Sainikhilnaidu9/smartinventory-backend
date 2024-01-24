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

import com.capstone.smartinventorymanagement.dto.OutwardItemDto;
import com.capstone.smartinventorymanagement.service.OutwardItemServices;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class OutwardItemTest {
	
	@InjectMocks
	OutwardItemController outwardItemController;
	
	@Mock
	private OutwardItemServices outwardItemServices;
	
	@Test
	public void getAllOutwardItemsTest() throws Exception{
		OutwardItemDto dto = new OutwardItemDto();
		dto.setId("1234");
		dto.setItemName("Abcd");
		dto.setInvoiceNumber(7121435);
		dto.setDeliverTo("Xyz");
		dto.setQuantity(14);
		dto.setPurpose("Abcd");
		dto.setRecieptNo(23836);
		dto.setBillValue(236);
		dto.setBillCheckedBy("Abcd");
		List<OutwardItemDto> list = new ArrayList<OutwardItemDto>();
		list.add(dto);
		Mockito.when(outwardItemServices.findAllOutwardItems()).thenReturn(list);
		List<OutwardItemDto> OutwardItemDto =outwardItemController.getAllOutwardItems();
		assertEquals(OutwardItemDto, list);
		
	}

}

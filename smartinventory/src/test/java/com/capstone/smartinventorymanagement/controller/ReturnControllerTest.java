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

import com.capstone.smartinventorymanagement.dto.ReturnDto;
import com.capstone.smartinventorymanagement.service.ReturnService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ReturnControllerTest {
	
	@InjectMocks
	ReturnController returnController;
	
	@Mock
	private ReturnService returnService;
	
	@Test
	public void getAllReturnsTest() throws Exception{
		ReturnDto dto = new ReturnDto();
		dto.setReturnId(87);
		dto.setItemName("Abcd");
		dto.setReturnQuantity(61);
		dto.setCheckedBy("Abcd");
		dto.setReturnReason("Abcd");
		List<ReturnDto> list = new ArrayList<ReturnDto>();
		list.add(dto);
		Mockito.when(returnService.fetchAllReturns()).thenReturn(list);
		List<ReturnDto> returnDto =returnController.getAllReturns();
		assertEquals(returnDto, list);
		
	}

}

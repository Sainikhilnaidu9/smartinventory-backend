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

import com.capstone.smartinventorymanagement.dto.GodownDto;
import com.capstone.smartinventorymanagement.service.GodownServices;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class GodownControllerTest {
	
	@InjectMocks
	GodownController godownController;
	
	@Mock
	private GodownServices godownServices;
	
	@Test
	public void getAllGodownsTest() throws Exception{
		GodownDto dto = new GodownDto();
		dto.setGodownId("1234");
		dto.setName("Abcd");
		List<GodownDto> list = new ArrayList<GodownDto>();
		list.add(dto);
		Mockito.when(godownServices.getAllGodowns()).thenReturn(list);
		List<GodownDto> godownDto =godownController.getAllGodowns();
		assertEquals(godownDto, list);
		
	}

}

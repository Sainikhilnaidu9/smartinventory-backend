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

import com.capstone.smartinventorymanagement.dto.ReportDto;
import com.capstone.smartinventorymanagement.service.ReportService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ReportControllerTest {
	
	@InjectMocks
	ReportController reportController;
	
	@Mock
	private ReportService reportService;
	
	@Test
	public void getAllReportsTest() throws Exception{
		ReportDto dto = new ReportDto();
		dto.setReportId(18);
		dto.setMonth("January");
		dto.setLocation("Abc");
		dto.setItemReceived(22);
		dto.setItemdelivered(12);
		dto.setItemsReturned(10);
		List<ReportDto> list = new ArrayList<ReportDto>();
		list.add(dto);
		Mockito.when(reportService.fetchAllReports()).thenReturn(list);
		List<ReportDto> reportDto =reportController.findAll();
		assertEquals(reportDto, list);
		
	}

}

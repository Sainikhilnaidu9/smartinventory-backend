package com.capstone.smartinventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.capstone.smartinventorymanagement.model.Report;
import com.capstone.smartinventorymanagement.service.ReportService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ReportControllerTest {

    @InjectMocks
    ReportController reportController;

    @Mock
    private ReportService reportService;

    @Test
    public void getAllReportsTest() {
        // Test case for successful retrieval
        ReportDto dto = new ReportDto();
        dto.setReportId(18);
        dto.setMonth("January");
        dto.setLocation("Abc");
        dto.setItemReceived(22);
        dto.setItemdelivered(12);
        dto.setItemsReturned(10);
        List<ReportDto> list = new ArrayList<>();
        list.add(dto);
        Mockito.when(reportService.fetchAllReports()).thenReturn(list);

        List<ReportDto> reportDtoList = reportController.findAll();
        assertEquals(reportDtoList, list);
    }

    @Test
    public void getReportByIdTest() {
        // Test case for successful retrieval
        Integer reportId = 18;
        ReportDto dto = new ReportDto();
        dto.setReportId(reportId);
        dto.setMonth("January");
        dto.setLocation("Abc");
        dto.setItemReceived(22);
        dto.setItemdelivered(12);
        dto.setItemsReturned(10);
        Mockito.when(((ReportService) reportService).findReportById(reportId)).thenReturn(dto);

        ReportDto resultDto = reportController.getReportById(reportId);
        assertEquals(resultDto, dto);
    }

    @Test
    public void postReportTest() {
        // Test case for successful creation
        Report report = new Report();
        // Set properties of report as needed for the test

        Mockito.when(((ReportService) reportService).insertReport(report)).thenReturn("Report created successfully");

        String successMessage = reportController.postReport(report);
        assertEquals(successMessage, "Report created successfully");
    }

    @Test
    public void putReportTest() {
        // Test case for successful update
        Integer reportId = 18;
        Report report = new Report();
        // Set properties of report as needed for the test

        Mockito.when(reportService.updateReport(report, reportId)).thenReturn("Report updated successfully");

        String successMessage = reportController.putReport(report, reportId);
        assertEquals(successMessage, "Report updated successfully");
    }

    @Test
    public void removeReportTest() {
        // Test case for successful removal
        Integer reportId = 18;
        Mockito.when(reportService.deleteReport(reportId)).thenReturn("Report deleted successfully");

        String successMessage = reportController.removeReport(reportId);
        assertEquals(successMessage, "Report deleted successfully");
    }

    // Additional test cases for specific error scenarios can be added as needed.
}

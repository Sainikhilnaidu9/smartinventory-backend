package com.capstone.smartinventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.capstone.smartinventorymanagement.dto.ReportDto;
import com.capstone.smartinventorymanagement.model.Report;
import com.capstone.smartinventorymanagement.service.ReportService;

@RestController
public class ReportController {
	@Autowired
	ReportService reportService;
	
	@GetMapping("/reports")
	public List<ReportDto> findAll(){
		
		
		return reportService.fetchAllReports();
	}

	@GetMapping("/report/{id}")
	public ReportDto getReportById(@PathVariable("id") Integer id) {
		return ((ReportService) reportService).findReportById(id);
		
	}
	
	@PostMapping("/report")
	public String postReport(@RequestBody Report report) {
		return ((ReportService) reportService).insertReport(report);
	}
	
	@PutMapping("/report/{id}")
	public String putReport(@RequestBody Report report,@PathVariable("id") Integer id) {
		return reportService.updateReport(report,id);
	}
	
	@DeleteMapping("/report/{id}")
	public String removeReport(@PathVariable("id") Integer id) {
		return reportService.deleteReport(id);
	}

	
}

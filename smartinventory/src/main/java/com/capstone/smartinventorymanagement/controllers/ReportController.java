package com.capstone.smartinventorymanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dtos.ReportDto;
import com.capstone.smartinventorymanagement.entity.Report;
import com.capstone.smartinventorymanagement.mappers.ReportMapper;
import com.capstone.smartinventorymanagement.repositories.ReportRepository;
import com.capstone.smartinventorymanagement.services.ReportService;

@RestController
public class ReportController {
	@Autowired
	ReportService reportService;
	
	@GetMapping("/reports")
	public List<ReportDto> findAll(){
		
		
		return reportService.fetchAllReports();
	}

	
}

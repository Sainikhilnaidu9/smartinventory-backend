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

@RestController
public class ReportController {
	@Autowired
	ReportRepository reportRepository;
	
	@GetMapping("/reports")
	public List<ReportDto> findAll(){
		Report rep = new Report();
		List<Report>reportList = reportRepository.findAll();
		List<ReportDto>reportDtoList = new ArrayList<>();
		for (Report report : reportList)
		{
			ReportDto reportDto = ReportMapper.convertToDto(report);
			reportDtoList.add(reportDto);
		}
		
		return reportDtoList;
	}

	
}

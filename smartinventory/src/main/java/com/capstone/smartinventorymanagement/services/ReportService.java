package com.capstone.smartinventorymanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dtos.ReportDto;
import com.capstone.smartinventorymanagement.entity.Report;
import com.capstone.smartinventorymanagement.mappers.ReportMapper;
import com.capstone.smartinventorymanagement.repositories.ReportRepository;

@Service
public class ReportService {
	ReportRepository reportRepository;

	public List<ReportDto> fetchAllReports() {
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

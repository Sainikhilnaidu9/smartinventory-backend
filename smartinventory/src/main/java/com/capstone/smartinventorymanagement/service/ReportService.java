package com.capstone.smartinventorymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dto.ReportDto;
import com.capstone.smartinventorymanagement.mapper.ReportMapper;
import com.capstone.smartinventorymanagement.model.Report;
import com.capstone.smartinventorymanagement.repository.ReportRepository;

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

package com.capstone.smartinventorymanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dtos.ReportDto;
import com.capstone.smartinventorymanagement.dtos.ReturnDto;
import com.capstone.smartinventorymanagement.entity.Report;
import com.capstone.smartinventorymanagement.entity.Return;
import com.capstone.smartinventorymanagement.exceptions.ReportNotFoundException;
import com.capstone.smartinventorymanagement.exceptions.ReturnIdNotFoundException;
import com.capstone.smartinventorymanagement.mappers.ReportMapper;
import com.capstone.smartinventorymanagement.mappers.ReturnMapper;
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

	public ReportDto findReportById(Integer id) {
		Optional<Report> op = reportRepository.findById(id);
		if(op.isPresent())
		{
			ReportDto reportDto = ReportMapper.convertToDto(op.get());
			return reportDto;
		}
		else 
			throw new ReportNotFoundException("No Report is found with id: " + id);
	}

	public String insertReport(Report report) {
		Report isSaved=reportRepository.save(report);
		if(isSaved==null) {
			return "Unable to Insert";
		}
		return "Report inserted Successfully";
	}

	public String updateReport(Report report, Integer id) {
		Optional<Report> op=reportRepository.findById(id);
		if(op.isPresent()) {
			Report isSaved=reportRepository.save(report);
			if(isSaved==null) {
				return "Not updated";
			}else {
				return "Updated successfully the repot with id: {id}";
			}
		}else {
			throw new ReportNotFoundException("No Report is found with id: " + id);
		}
	}

	public String deleteReport(Integer id) {
		if(reportRepository.existsById(id)) {
			reportRepository.deleteById(id);
			return "Deleted";
		}else {
			throw new ReportNotFoundException("No Report is found with id: " + id);
		}
	}
	

}

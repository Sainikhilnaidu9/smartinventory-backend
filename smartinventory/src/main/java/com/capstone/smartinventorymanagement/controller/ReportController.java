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

<<<<<<< HEAD:smartinventory/src/main/java/com/capstone/smartinventorymanagement/controller/ReportController.java
import com.capstone.smartinventorymanagement.dto.ReportDto;
import com.capstone.smartinventorymanagement.service.ReportService;
=======
import com.capstone.smartinventorymanagement.dtos.ReportDto;
import com.capstone.smartinventorymanagement.entity.Report;
import com.capstone.smartinventorymanagement.services.ReportService;
>>>>>>> 26102eab6d8bf404f45b644404fc2bd8e15523a9:smartinventory/src/main/java/com/capstone/smartinventorymanagement/controllers/ReportController.java

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

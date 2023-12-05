package com.capstone.smartinventorymanagement.mappers;

import com.capstone.smartinventorymanagement.dtos.ReportDto;
import com.capstone.smartinventorymanagement.entity.Report;

public class ReportMapper {
	public static ReportDto convertToDto(Report report){
		ReportDto reportDto =new ReportDto();
		reportDto.setReportId(report.getReportId());
		reportDto.setMonth(report.getMonth());
		reportDto.setLocation(report.getLocation());
		reportDto.setItemReceived(report.getItemReceived());
		reportDto.setItemdelivered(report.getItemDelivered());
		reportDto.setItemsReturned(report.getItemsReturned());
		return reportDto;
	}
}

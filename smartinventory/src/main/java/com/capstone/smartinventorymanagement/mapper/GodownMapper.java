package com.capstone.smartinventorymanagement.mapper;

import com.capstone.smartinventorymanagement.dto.GodownDto;
import com.capstone.smartinventorymanagement.model.Godown;

public class GodownMapper {
	public static GodownDto convertToDto (Godown godown) {
		GodownDto godownDto =new GodownDto();
		godownDto.setGodownId(godown.getGodownId());
		godownDto.setName(godown.getName());
		godownDto.setLocation(godown.getLocation());
		godownDto.setStartDate(godown.getStartDate());
		
		return godownDto;
		
	}

}

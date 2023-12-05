package com.capstone.smartinventorymanagement.mappers;

import com.capstone.smartinventorymanagement.dtos.GodownDto;
import com.capstone.smartinventorymanagement.entity.Godown;

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

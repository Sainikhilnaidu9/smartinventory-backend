package com.capstone.smartinventorymanagement.mappers;

import com.capstone.smartinventorymanagement.dtos.ReturnDto;
import com.capstone.smartinventorymanagement.entity.Return;

public class ReturnMapper {
	public static ReturnDto convertToDto(Return returnItem){
		ReturnDto returnItemDto =new ReturnDto();
		returnItemDto.setReturnId(returnItem.getReturnId());
		returnItemDto.setItemName(returnItem.getItemName());
		returnItemDto.setDateOfReturn(returnItem.getDateOfReturn());
		returnItemDto.setReturnQuantity(returnItem.getReturnQuantity());
		returnItemDto.setCheckedBy(returnItem.getCheckedBy());
		returnItemDto.setReturnReason(returnItem.getReturnReason());
		return returnItemDto;
	}
}

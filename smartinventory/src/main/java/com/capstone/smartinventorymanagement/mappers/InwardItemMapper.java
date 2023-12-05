package com.capstone.smartinventorymanagement.mappers;

import com.capstone.smartinventorymanagement.dtos.InwardItemDto;
import com.capstone.smartinventorymanagement.entity.InwardItem;

public class InwardItemMapper {
	public static InwardItemDto convertToDto(InwardItem inwardItem) {
		InwardItemDto inwardItemDto=new InwardItemDto();
		inwardItemDto.setId(inwardItem.getId());
		inwardItemDto.setNameOfSupplier(inwardItem.getNameOfSupplier());
		inwardItemDto.setDateOfSupply(inwardItem.getDateOfSupply());
		inwardItemDto.setItemName(inwardItem.getItemName());
		inwardItemDto.setInvoiceNumber(inwardItem.getInvoiceNumber());
		inwardItemDto.setRecievedBy(inwardItem.getRecievedBy());
		inwardItemDto.setBillCheckedBy(inwardItem.getBillCheckedBy());
		inwardItemDto.setRecieptNo(inwardItem.getRecieptNo());
		return inwardItemDto;
	}

}

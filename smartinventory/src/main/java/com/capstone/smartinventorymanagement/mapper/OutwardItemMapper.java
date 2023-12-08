package com.capstone.smartinventorymanagement.mapper;

import com.capstone.smartinventorymanagement.dto.OutwardItemDto;
import com.capstone.smartinventorymanagement.model.OutwardItem;

public class OutwardItemMapper {
	public static OutwardItemDto convertToDto(OutwardItem outwardItem) {
		OutwardItemDto outwardItemDto=new OutwardItemDto();
		outwardItemDto.setId(outwardItem.getId());
		outwardItemDto.setItemName(outwardItem.getItemName());
		outwardItemDto.setInvoiceNumber(outwardItem.getInvoiceNumber());
		outwardItemDto.setOutwardDate(outwardItem.getOutwardDate());
		outwardItemDto.setDeliveryDate(outwardItem.getDeliveryDate());
		outwardItemDto.setDeliverTo(outwardItem.getDeliverTo());
		outwardItemDto.setQuantity(outwardItem.getQuantity());
		outwardItemDto.setPurpose(outwardItem.getPurpose());
		outwardItemDto.setRecieptNo(outwardItem.getRecieptNo());
		outwardItemDto.setBillValue(outwardItem.getBillValue());
		outwardItemDto.setBillCheckedBy(outwardItem.getBillCheckedBy());
		
		return outwardItemDto;
	}

}

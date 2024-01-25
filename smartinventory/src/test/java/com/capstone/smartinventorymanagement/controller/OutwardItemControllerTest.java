 package com.capstone.smartinventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capstone.smartinventorymanagement.dto.OutwardItemDto;
import com.capstone.smartinventorymanagement.model.OutwardItem;
import com.capstone.smartinventorymanagement.service.OutwardItemServices;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class OutwardItemControllerTest {

    @InjectMocks
    OutwardItemController outwardItemController;

    @Mock
    private OutwardItemServices outwardItemServices;

    @Test
    public void getAllOutwardItemsTest() {
        // Test case for successful retrieval
        OutwardItemDto dto = new OutwardItemDto();
        dto.setId("1234");
        dto.setItemName("Abcd");
        dto.setInvoiceNumber(7121435);
        dto.setDeliverTo("Xyz");
        dto.setQuantity(14);
        dto.setPurpose("Abcd");
        dto.setRecieptNo(23836);
        dto.setBillValue(236);
        dto.setBillCheckedBy("Abcd");
        List<OutwardItemDto> list = new ArrayList<>();
        list.add(dto);
        Mockito.when(outwardItemServices.findAllOutwardItems()).thenReturn(list);

        List<OutwardItemDto> outwardItemDtoList = outwardItemController.getAllOutwardItems();
        assertEquals(outwardItemDtoList, list);
    }

    @Test
    public void getOutwardItemByIdTest() {
        // Test case for successful retrieval
        String itemId = "1234";
        OutwardItemDto dto = new OutwardItemDto();
        dto.setId(itemId);
        dto.setItemName("Abcd");
        dto.setInvoiceNumber(7121435);
        dto.setDeliverTo("Xyz");
        dto.setQuantity(14);
        dto.setPurpose("Abcd");
        dto.setRecieptNo(23836);
        dto.setBillValue(236);
        dto.setBillCheckedBy("Abcd");
        Mockito.when(outwardItemServices.findOutwardItemById(itemId)).thenReturn(dto);

        OutwardItemDto resultDto = outwardItemController.getOutwardItemById(itemId);
        assertEquals(resultDto, dto);
    }

    @Test
    public void postOutwardItemTest() {
        // Test case for successful creation
        OutwardItem outwardItem = new OutwardItem();
        // Set properties of outwardItem as needed for the test

        Mockito.when(outwardItemServices.insertOutwardItem(outwardItem)).thenReturn("Outward item created successfully");

        String successMessage = outwardItemController.postOutwardItem(outwardItem);
        assertEquals(successMessage, "Outward item created successfully");
    }

    @Test
    public void putOutwardItemTest() {
        // Test case for successful update
        String itemId = "1234";
        OutwardItem outwardItem = new OutwardItem();
        // Set properties of outwardItem as needed for the test

        Mockito.when(outwardItemServices.updateOutwardItem(outwardItem, itemId))
                .thenReturn("Outward item updated successfully");

        String successMessage = outwardItemController.putOutwardItem(outwardItem, itemId);
        assertEquals(successMessage, "Outward item updated successfully");
    }

    @Test
    public void removeOutwardItemTest() {
        // Test case for successful removal
        String itemId = "1234";
        Mockito.when(outwardItemServices.deleteOutwardItem(itemId)).thenReturn("Outward item deleted successfully");

        String successMessage = outwardItemController.removeOutwardItem(itemId);
        assertEquals(successMessage, "Outward item deleted successfully");
    }

    // Additional test cases for specific error scenarios can be added as needed.
}

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

import com.capstone.smartinventorymanagement.dto.InwardItemDto;
import com.capstone.smartinventorymanagement.model.InwardItem;
import com.capstone.smartinventorymanagement.service.InwardItemServices;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class InwardItemControllerTest {

    @InjectMocks
    InwardItemController inwardItemController;

    @Mock
    private InwardItemServices inwardItemServices;

    @Test
    public void getAllInwardItemsTest() {
        // Test case for successful retrieval
        InwardItemDto dto = new InwardItemDto();
        dto.setId("1234");
        dto.setNameOfSupplier("Abc");
        dto.setItemName("Abcd");
        dto.setInvoiceNumber(12361547);
        dto.setRecievedBy("Abcd");
        dto.setBillCheckedBy("Abcd");
        dto.setRecieptNo(63422342);
        dto.setQuantity(13);
        List<InwardItemDto> list = new ArrayList<>();
        list.add(dto);
        Mockito.when(inwardItemServices.findAllInwardItems()).thenReturn(list);

        List<InwardItemDto> inwardItemsDtoList = inwardItemController.getAllInwardItems();
        assertEquals(inwardItemsDtoList, list);
    }

    @Test
    public void getInwardItemByIdTest() {
        // Test case for successful retrieval
        String itemId = "1234";
        InwardItemDto dto = new InwardItemDto();
        dto.setId("1234");
        dto.setNameOfSupplier("Abc");
        dto.setItemName("Abcd");
        dto.setInvoiceNumber(12361547);
        dto.setRecievedBy("Abcd");
        dto.setBillCheckedBy("Abcd");
        dto.setRecieptNo(63422342);
        dto.setQuantity(13);
        Mockito.when(inwardItemServices.findInwardItemById(itemId)).thenReturn(dto);

        InwardItemDto resultDto = inwardItemController.getInwardItemById(itemId);
        assertEquals(resultDto, dto);
    }

    @Test
    public void postInwardItemTest() {
        // Test case for successful creation
        InwardItem inwardItem = new InwardItem();
        // Set properties of inwardItem as needed for the test

        Mockito.when(inwardItemServices.insertInwardItem(inwardItem)).thenReturn("Inward item created successfully");

        String successMessage = inwardItemController.postInwardItem(inwardItem);
        assertEquals(successMessage, "Inward item created successfully");
    }

    @Test
    public void putInwardItemTest() {
        // Test case for successful update
        String itemId = "1234";
        InwardItem inwardItem = new InwardItem();
        // Set properties of inwardItem as needed for the test

        Mockito.when(inwardItemServices.updateInwardItem(inwardItem, itemId)).thenReturn("Inward item updated successfully");

        String successMessage = inwardItemController.putInwardItem(inwardItem, itemId);
        assertEquals(successMessage, "Inward item updated successfully");
    }

    @Test
    public void removeInwardItemTest() {
        // Test case for successful removal
        String itemId = "1234";
        Mockito.when(inwardItemServices.deleteInwardItem(itemId)).thenReturn("Inward item deleted successfully");

        String successMessage = inwardItemController.removeInwardItem(itemId);
        assertEquals(successMessage, "Inward item deleted successfully");
    }

    // Additional test cases for specific error scenarios can be added as needed.
}

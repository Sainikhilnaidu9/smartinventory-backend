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

import com.capstone.smartinventorymanagement.controller.StockController;
import com.capstone.smartinventorymanagement.dto.StockDto;
import com.capstone.smartinventorymanagement.service.StockServices;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class StockControllerTest {

    @InjectMocks
    StockController stockController;

    @Mock
    private StockServices stockServices;

    @Test
    public void getItemByIdTest() throws Exception {
        int itemId = 1234;
        StockDto dto = new StockDto();
        dto.setItemId(itemId);
        dto.setItemName("Abcd");
        dto.setItemPrice(12347);
        dto.setItemQuantity(13);
        Mockito.when(stockServices.getItemById(itemId)).thenReturn(dto);

        StockDto stockDto = stockController.getItemById(itemId);
        assertEquals(stockDto, dto);
    }

    @Test
    public void createItemTest() throws Exception {
        StockDto stockDto = new StockDto();
        // Set properties of stockDto as needed for the test

        Mockito.when(stockServices.createItem(stockDto)).thenReturn("Item created successfully");

        String successMessage = stockController.createItem(stockDto);
        assertEquals(successMessage, "Item created successfully");
    }

    @Test
    public void updateItemTest() throws Exception {
        int itemId = 1234;
        StockDto stockDto = new StockDto();
        // Set properties of stockDto as needed for the test

        Mockito.when(stockServices.updateItem(itemId, stockDto)).thenReturn("Item updated successfully");

        String successMessage = stockController.updateItem(itemId, stockDto);
        assertEquals(successMessage, "Item updated successfully");
    }

    @Test
    public void deleteItemTest() throws Exception {
        int itemId = 1234;
        Mockito.when(stockServices.deleteItem(itemId)).thenReturn("Item deleted successfully");

        String successMessage = stockController.deleteItem(itemId);
        assertEquals(successMessage, "Item deleted successfully");
    }

    // Additional test cases for specific error scenarios can be added as needed.
}

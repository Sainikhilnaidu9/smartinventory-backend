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

import com.capstone.smartinventorymanagement.dto.ReturnDto;
import com.capstone.smartinventorymanagement.model.Return;
import com.capstone.smartinventorymanagement.service.ReturnService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ReturnControllerTest {

    @InjectMocks
    ReturnController returnController;

    @Mock
    private ReturnService returnService;

    @Test
    public void getReturnItemByIdTest() throws Exception {
        Integer returnId = 87;
        ReturnDto dto = new ReturnDto();
        dto.setReturnId(returnId);
        dto.setItemName("Abcd");
        dto.setReturnQuantity(61);
        dto.setCheckedBy("Abcd");
        dto.setReturnReason("Abcd");
        Mockito.when(((ReturnService) returnService).findReturnItemsById(returnId)).thenReturn(dto);

        ReturnDto returnDto = returnController.getReturnItemById(returnId);
        assertEquals(returnDto, dto);
    }

    @Test
    public void postReturnsTest() throws Exception {
        Return returns = new Return();
        // Set properties of returns as needed for the test

        Mockito.when(((ReturnService) returnService).insertReturn(returns)).thenReturn("Return created successfully");

        String successMessage = returnController.postReturns(returns);
        assertEquals(successMessage, "Return created successfully");
    }

    @Test
    public void putReturnTest() throws Exception {
        Integer returnId = 87;
        Return returns = new Return();
        // Set properties of returns as needed for the test

        Mockito.when(returnService.updateReturn(returns, returnId)).thenReturn("Return updated successfully");

        String successMessage = returnController.putReturn(returns, returnId);
        assertEquals(successMessage, "Return updated successfully");
    }

    @Test
    public void removeReturnTest() throws Exception {
        Integer returnId = 87;
        Mockito.when(returnService.deleteReturn(returnId)).thenReturn("Return deleted successfully");

        String successMessage = returnController.removeReturn(returnId);
        assertEquals(successMessage, "Return deleted successfully");
    }

    // Additional test cases for specific error scenarios can be added as needed.
}

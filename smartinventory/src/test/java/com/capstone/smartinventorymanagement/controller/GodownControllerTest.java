package com.capstone.smartinventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

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

import com.capstone.smartinventorymanagement.dto.GodownDto;
import com.capstone.smartinventorymanagement.service.GodownServices;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class GodownControllerTest {

    @InjectMocks
    GodownController godownController;

    @Mock
    private GodownServices godownServices;

    @Test
    public void getAllGodownsTest() {
        // Test case for successful retrieval
        GodownDto dto = new GodownDto();
        dto.setGodownId("1234");
        dto.setName("Abcd");
        List<GodownDto> list = new ArrayList<>();
        list.add(dto);
        Mockito.when(godownServices.getAllGodowns()).thenReturn(list);

        List<GodownDto> godownDtoList = godownController.getAllGodowns();
        assertEquals(godownDtoList, list);
    }

    @Test
    public void getGodownByIdTest() {
        // Test case for successful retrieval
        String godownId = "1234";
        GodownDto dto = new GodownDto();
        dto.setGodownId(godownId);
        dto.setName("Abcd");
        Mockito.when(godownServices.getGodownById(godownId)).thenReturn(dto);

        GodownDto resultDto = godownController.getGodownById(godownId);
        assertEquals(resultDto, dto);
    }

    @Test
    public void createGodownTest() {
        // Test case for successful creation
        GodownDto godownDto = new GodownDto();
        godownDto.setName("Godown1");

        Mockito.when(godownServices.createGodown(godownDto)).thenReturn("Godown created successfully");

        String successMessage = godownController.createGodown(godownDto);
        assertEquals(successMessage, "Godown created successfully");
    }

    @Test
    public void updateGodownTest() {
        // Test case for successful update
        String godownId = "1234";
        GodownDto godownDto = new GodownDto();
        godownDto.setName("Updated Godown");

        Mockito.when(godownServices.updateGodown(godownId, godownDto)).thenReturn("Godown updated successfully");

        String successMessage = godownController.updateGodown(godownId, godownDto);
        assertEquals(successMessage, "Godown updated successfully");
    }

    @Test
    public void deleteGodownTest() {
        // Test case for successful deletion
        String godownId = "1234";
        Mockito.when(godownServices.deleteGodown(godownId)).thenReturn("Godown deleted successfully");

        String successMessage = godownController.deleteGodown(godownId);
        assertEquals(successMessage, "Godown deleted successfully");
    }

    // Additional test cases for specific error scenarios can be added as needed.
}

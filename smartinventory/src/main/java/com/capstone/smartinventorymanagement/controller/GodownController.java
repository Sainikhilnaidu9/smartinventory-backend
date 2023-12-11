package com.capstone.smartinventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dto.GodownDto;
import com.capstone.smartinventorymanagement.service.GodownServices;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/godowncontrollerapi")
public class GodownController {

    @Autowired
    private GodownServices godownServices;

    @GetMapping("/godowns")
    @Operation(summary = "Get all godowns")
    public List<GodownDto> getAllGodowns() {
        return godownServices.getAllGodowns();
    }
    
    
    @GetMapping("/godowns/{id}")
    @Operation(summary = "Get a godown by id")
    public GodownDto getGodownById(@PathVariable("id") String id) {
        return godownServices.getGodownById(id);
    }

    @PostMapping("/godowns/createGodown")
    @Operation(summary = "Create a new godown")
    public String createGodown(@RequestBody GodownDto godownDto) {
        return godownServices.createGodown(godownDto);
    }
    

    @PutMapping("/godowns/update/{id}")
    @Operation(summary = "Update an existing godown")
    public String updateGodown(@PathVariable String id, @RequestBody GodownDto godownDto) {
        return godownServices.updateGodown(id, godownDto);
    }

    @DeleteMapping("/godowns/delete/{id}")
    @Operation(summary = "Delete a godown")
    public String deleteGodown(@PathVariable String id) {
        return godownServices.deleteGodown(id);
    }
}



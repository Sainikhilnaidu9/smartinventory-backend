package com.capstone.smartinventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dto.StockDto;
import com.capstone.smartinventorymanagement.service.StockServices;

import io.swagger.v3.oas.annotations.Operation;

 

@RestController
public class StockController {

    @Autowired
    private StockServices stockServices;

    @GetMapping("/items")
    @Operation(summary = "Get all stock items")
    public List<StockDto> getAllItems() {
        return stockServices.getAllItems();
    }
    
    
    @GetMapping("/items/{id}")
    @Operation(summary = "Get a stock item by id")
    public StockDto getItemById(@PathVariable("id") int id) {
        return stockServices.getItemById(id);
    }

    @PostMapping("/items/createItem")
    @Operation(summary = "Create a new stock item")
    public String createItem(@RequestBody StockDto stockDto) {
        return stockServices.createItem(stockDto);
    }
    

    @PutMapping("/items/update/{id}")
    @Operation(summary = "Update an existing stock item")
    public String updateItem(@PathVariable int id, @RequestBody StockDto stockDto) {
        return stockServices.updateItem(id, stockDto);
    }

    @DeleteMapping("/items/delete/{id}")
    @Operation(summary = "Delete a stock item")
    public String deleteItem(@PathVariable int id) {
        return stockServices.deleteItem(id);
    }
}
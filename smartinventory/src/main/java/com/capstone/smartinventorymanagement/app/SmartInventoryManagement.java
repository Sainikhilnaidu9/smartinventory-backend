package com.capstone.smartinventorymanagement.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.capstone.smartinventorymanagement.entity","com.capstone.smartinventorymanagement.dtos","com.capstone.smartinventorymanagement.mappers","com.capstone.smartinventorymanagement.services","com.capstone.smartinventorymanagement.controllers","com.capstone.smartinventorymanagement.repositories"})
public class SmartInventoryManagement {

	public static void main(String[] args) {
		SpringApplication.run(SmartInventoryManagement.class, args);
	}

}

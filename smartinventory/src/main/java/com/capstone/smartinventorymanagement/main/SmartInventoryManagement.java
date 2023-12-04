package com.capstone.smartinventorymanagement.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.capstone.smartinventorymanagement.entity")
public class SmartInventoryManagement {

	public static void main(String[] args) {
		SpringApplication.run(SmartInventoryManagement.class, args);
	}

}

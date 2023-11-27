package com.capstone.smartinventorymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SmartInventoryManagement {

	public static void main(String[] args) {
		SpringApplication.run(SmartInventoryManagement.class, args);
	}

}

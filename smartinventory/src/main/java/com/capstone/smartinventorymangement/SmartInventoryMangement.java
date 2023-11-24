package com.capstone.smartinventorymangement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SmartInventoryMangement {

	public static void main(String[] args) {
		SpringApplication.run(SmartInventoryMangement.class, args);
	}

}


package com.capstone.smartinventorymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication /* (exclude = {DataSourceAutoConfiguration.class}) */
//@EntityScan("com.capstone.smartinventorymanagement.model")
//@ComponentScan(basePackages = "com.capstone.smartinventorymanagement.model")
//@EnableJpaRepositories(basePackages = {"com.capstone.smartinventorymanagement.repository"})
//@ComponentScan(basePackages = {"com.capstone.smartinventorymanagement","com.capstone.smartinventorymanagement.dto","com.capstone.smartinventorymanagement.mapper","com.capstone.smartinventorymanagement.service","com.capstone.smartinventorymanagement.controllers","com.capstone.smartinventorymanagement.repositories"})

public class SmartInventoryManagement {

	public static void main(String[] args) {
		SpringApplication.run(SmartInventoryManagement.class, args);
		
	}
}

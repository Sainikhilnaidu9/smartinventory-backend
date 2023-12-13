package com.capstone.smartinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{

}

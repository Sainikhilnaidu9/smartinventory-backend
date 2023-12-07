package com.capstone.smartinventorymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

}

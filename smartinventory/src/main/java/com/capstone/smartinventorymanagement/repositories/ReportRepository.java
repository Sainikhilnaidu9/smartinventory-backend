package com.capstone.smartinventorymanagement.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

}

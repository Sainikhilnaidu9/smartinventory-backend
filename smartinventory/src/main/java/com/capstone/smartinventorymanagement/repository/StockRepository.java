package com.capstone.smartinventorymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{
}

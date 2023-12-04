package com.capstone.smartinventorymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

}

package com.capstone.smartinventorymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.entity.InwardItems;

@Repository
public interface InwardItemsRepository extends JpaRepository<InwardItems, String>{

}

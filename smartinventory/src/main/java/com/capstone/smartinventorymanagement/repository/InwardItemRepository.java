package com.capstone.smartinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.model.InwardItem;

@Repository
public interface InwardItemRepository extends JpaRepository<InwardItem, String>{

}

package com.capstone.smartinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.model.Godown;

@Repository
public interface GodownRepository extends JpaRepository<Godown, String>{
	

}


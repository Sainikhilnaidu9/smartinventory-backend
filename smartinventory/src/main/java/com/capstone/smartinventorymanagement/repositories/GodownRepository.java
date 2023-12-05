package com.capstone.smartinventorymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.entity.Godown;

@Repository
public interface GodownRepository extends JpaRepository<Godown, String>{
	

}


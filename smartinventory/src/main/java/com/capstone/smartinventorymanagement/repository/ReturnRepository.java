package com.capstone.smartinventorymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.model.Return;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Integer>{

}


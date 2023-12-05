package com.capstone.smartinventorymanagement.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.entity.Return;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Integer>{

}


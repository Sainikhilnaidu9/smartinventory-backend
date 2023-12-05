package com.capstone.smartinventorymanagement.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.entity.OutwardItems;

@Repository
public interface OutwardItemsRepository extends JpaRepository<OutwardItems, String>{

}

package com.capstone.smartinventorymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.smartinventorymanagement.model.OutwardItem;

@Repository
public interface OutwardItemRepository extends JpaRepository<OutwardItem, String>{

}

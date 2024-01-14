package com.capstone.smartinventorymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.smartinventorymanagement.dto.AuthUserDto;
import com.capstone.smartinventorymanagement.model.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
	Optional<AuthUser>findByUserEmail(String name);
	boolean existsByUserEmail(String name);
	

}

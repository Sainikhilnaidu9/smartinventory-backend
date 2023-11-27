package com.capstone.smartinventorymangement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymangement.entity.User;

@Service
public class UserService {

	private User user;
	
	@Autowired
	public UserService(@Lazy User user) {
		super();
		this.user = user;
	}

	
	
	
	
}

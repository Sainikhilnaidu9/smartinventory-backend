package com.capstone.smartinventorymanagement.mapper;

import com.capstone.smartinventorymanagement.dto.AuthUserDto;
import com.capstone.smartinventorymanagement.model.AuthUser;

public class AuthUserMapper {
	public static AuthUserDto convertToDto(AuthUser authUser) {
		
		AuthUserDto authUserDto = new AuthUserDto();
		authUserDto.setUserEmail(authUser.getUserEmail());
		authUserDto.setUserPassword(authUser.getUserPassword());
		return authUserDto;
	}

}

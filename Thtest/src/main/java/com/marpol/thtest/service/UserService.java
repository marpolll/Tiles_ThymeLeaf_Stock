package com.marpol.thtest.service;

import com.marpol.thtest.models.UserDto;

public interface UserService {

	public int join(UserDto userDto);
	
	public UserDto login(UserDto userDto) throws Exception;
	
}

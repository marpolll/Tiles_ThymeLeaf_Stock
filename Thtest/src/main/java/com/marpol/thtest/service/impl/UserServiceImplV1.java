package com.marpol.thtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marpol.thtest.models.UserDto;
import com.marpol.thtest.persistance.UserDao;
import com.marpol.thtest.service.UserService;

@Service
public class UserServiceImplV1 implements UserService {

	protected final UserDao userDao;

	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void create_table() {
		userDao.create_user_table();
	}

	@Override
	public int join(UserDto userDto) {

		int userCount = userDao.userCount();
		if (userCount > 0) {
			userDto.setU_role("USER");
		} else {
			userDto.setU_role("ADMIN");
		}
		return userDao.insert(userDto);
	}

	@Override
	public UserDto login(UserDto userDto) throws Exception {

		if (userDto.getUsername().isBlank()) {
			throw new Exception("USER_EMPTY");
		} else if (userDto.getPassword().isBlank()) {
			throw new Exception("PASSWORD_EMPTY");
		}

		UserDto resultDto = userDao.findById(userDto.getUsername());
		if (resultDto == null) {
			throw new Exception("USERNAME");
		} else if (resultDto != null && !userDto.getPassword().equals(resultDto.getPassword())) {
			throw new Exception("PASSWORD");
		}

		return resultDto;
	}

}

package com.marpol.thtest.persistance;

import org.apache.ibatis.annotations.Select;

import com.marpol.thtest.models.UserDto;

public interface UserDao {
	
	@Select(" SELECT COUNT(*) FROM tbl_users ")
	public int userCount();
	
	@Select(" SELECT * FROM tbl_users WHERE username = #{username} ")
	public UserDto findById(String username);
	
	public int insert(UserDto userdto);
	public int update(UserDto userdto);
	public int delete(UserDto userdto);
	
	public void create_user_table();
	
}

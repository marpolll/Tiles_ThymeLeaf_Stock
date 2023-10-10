package com.marpol.thtest.models;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserDto {

	private String username;
	private String password;
	private String u_name;
	private String u_nickname;
	private String u_tel;
	private String u_role;
	
}

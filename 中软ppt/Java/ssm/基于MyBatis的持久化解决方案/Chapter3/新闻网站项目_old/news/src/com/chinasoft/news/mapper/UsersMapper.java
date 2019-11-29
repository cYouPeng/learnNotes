package com.chinasoft.news.mapper;

import com.chinasoft.news.entity.Users;

public interface UsersMapper {

	public Users selectUsersByNameByPass(Users users);
	public int insertUsers(Users users);
}

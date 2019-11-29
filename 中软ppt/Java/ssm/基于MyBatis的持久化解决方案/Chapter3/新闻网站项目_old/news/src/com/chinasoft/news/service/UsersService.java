package com.chinasoft.news.service;

import com.chinasoft.news.entity.Users;

public interface UsersService {

	public Users selectUsersByNameByPass(Users users);
	public int insertUsers(Users users);
}

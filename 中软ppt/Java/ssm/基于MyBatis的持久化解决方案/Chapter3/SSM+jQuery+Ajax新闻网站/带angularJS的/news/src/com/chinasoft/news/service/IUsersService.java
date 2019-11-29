package com.chinasoft.news.service;

import com.chinasoft.news.entity.Users;

public interface IUsersService {

	public Users selectUsersByPass(Users users);
	public Users selectUsersById(int userId);

}

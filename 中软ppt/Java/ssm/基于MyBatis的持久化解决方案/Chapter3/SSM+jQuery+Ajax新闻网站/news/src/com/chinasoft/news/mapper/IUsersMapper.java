package com.chinasoft.news.mapper;

import com.chinasoft.news.entity.Users;

public interface IUsersMapper {

	public Users selectUsersByPass(Users users);
	public Users selectUsersById(int userId);

}

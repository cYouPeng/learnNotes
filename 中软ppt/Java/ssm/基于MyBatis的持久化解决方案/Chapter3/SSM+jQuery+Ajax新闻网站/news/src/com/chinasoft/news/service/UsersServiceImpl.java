package com.chinasoft.news.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.news.entity.Users;
import com.chinasoft.news.mapper.IUsersMapper;


@Service
public class UsersServiceImpl implements IUsersService{
	
	@Autowired
	private IUsersMapper usersMapper;

	public Users selectUsersByPass(Users users){
		return usersMapper.selectUsersByPass(users);
	}
	
	public Users selectUsersById(int userId){
		return usersMapper.selectUsersById(userId);
	}

}

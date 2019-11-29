package com.chinasoft.news.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.news.common.NewsCommon;
import com.chinasoft.news.entity.Users;
import com.chinasoft.news.mapper.UsersMapper;

@Service
@Transactional  
public class UsersServiceImpl implements UsersService{

	@Resource
	private UsersMapper usersMapper;

	@Override
	public Users selectUsersByNameByPass(Users users) {
		users.setPassword(NewsCommon.getMD5String(users.getPassword()));
		return usersMapper.selectUsersByNameByPass(users);
	}
	
	public int insertUsers(Users users){
		users.setPassword(NewsCommon.getMD5String(users.getPassword()));
		return usersMapper.insertUsers(users);
	}
}

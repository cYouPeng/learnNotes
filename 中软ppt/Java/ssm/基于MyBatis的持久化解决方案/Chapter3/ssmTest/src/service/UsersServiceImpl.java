package service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.IUsersMapper;
import entity.Users;

@Service
public class UsersServiceImpl implements IUsersService{
	
	//@Resource()
	@Autowired
	private IUsersMapper usersMapper;

	public Users selectUsersByPass(Users users){
		return usersMapper.selectUsersByPass(users);
	}

	/*
	public IUsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(IUsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}
	*/
	
}

package service;

import entity.Users;

public interface IUsersService {

	public Users selectUsersByPass(Users users);
}

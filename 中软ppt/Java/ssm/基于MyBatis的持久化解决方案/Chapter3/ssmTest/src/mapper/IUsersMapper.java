package mapper;

import entity.Users;

public interface IUsersMapper {

	public Users selectUsersByPass(Users users);
}

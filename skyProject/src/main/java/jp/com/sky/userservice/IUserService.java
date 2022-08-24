package jp.com.sky.userservice;

import jp.com.sky.shopdto.UserDto;

public interface IUserService {
	void userRegister(String userName, String userId, String userPw, String email, String managerId);

	UserDto userSearch(String userId, String userPw);
}

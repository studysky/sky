package jp.com.sky.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.com.sky.dao.UserDao;
import jp.com.sky.shopdto.UserDto;

@Service // 사용자의 요청에 대해 어던 처리를 할지 결장하는 클랴스 , controller가 받운 요청에 대해 알맞는 정보를 가공해서 다시
			// controller 에게 데이터를 넘기는것을 의미한다
public class UserService implements IUserService {

	@Autowired
	UserDao dao;

	@Override
	public void userRegister(String userName, String userId, String userPw, String email, String managerId) {

	}

	@Override
	public UserDto userSearch(String userId, String userPw) {

//		System.out.println("userSearch()");
//		System.out.println("userId : " + userId);
//		System.out.println("userPw : " + userPw);

		UserDto userDto = new UserDto();

		return userDto;
	}

}

//package com.tps.user.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.tps.dao.UserDao;
//import com.tps.dto.UserDto;
//
//@Service
//	public class UserService implements IUserService {
//		
//		@Autowired
//		UserDao dao;
//
//		@Override
//		public void userRegister(String userName, String userId, String userPw, String email, String managerId) {
//		
//			System.out.println("userRegister()");
//			System.out.println("userName : " + userName);
//			System.out.println("userId : " + userId);
//			System.out.println("userPw : " + userPw);
//			System.out.println("eamil : " + email);
//			System.out.println("managerId : " + managerId);
//			
//			UserDao.userInsert(userName, userId, userPw, email, managerId);
//			}
//
//		@Override
//		public UserDto userSearch(String userId, String userPw) {
//			
//			System.out.println("userSearch()");
//			System.out.println("userId : " + userId);
//			System.out.println("userPw : " + userPw);
//			
//			UserDto userDto = UserDto.toString();
//			
//			return userDto;
//		}
//
//		
//	}

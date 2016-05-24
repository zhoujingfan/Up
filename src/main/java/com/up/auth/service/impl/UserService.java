package com.up.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.up.auth.service.IUserService;
import com.up.dao.IBaseDao;
import com.up.model.UserEntity;

@Service("userService")
public class UserService implements IUserService {
	//TODO Update all the service class to match the new dao;
	@Autowired
	private IBaseDao<UserEntity> userDao;

	@Override
	public UserEntity loadUserByUsername(String username) {
		List<Object>  param = new ArrayList<Object>();
		param.add(username);
		return userDao.get("from UserEntity where username=?", param);
	}

	@Override
	public void register(String username, String password, String email, String phone, String nickname,
			String address, String signature, String gender) {
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		param.add(email);
		param.add(phone);
		param.add(nickname);
		if(userDao.find("from UserEntity where username=? or email=? or phone=? or nickname=?", param).isEmpty()){
			UserEntity user = new UserEntity(username,password,email,phone,nickname,signature,address,gender);
			userDao.save(user);
		}
	}

	@Override
	public void setAvatar(String username, String destUri) {
		List<Object>  param = new ArrayList<Object>();
		param.add(destUri);
		param.add(username);
		userDao.executeHql("update UserEntity set avatar=? where username=?", param);
	}

}
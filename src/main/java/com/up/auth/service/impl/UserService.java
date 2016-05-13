package com.up.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.up.auth.dao.IUserEntityDao;
import com.up.auth.service.IUserService;
import com.up.model.UserEntity;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserEntityDao userDao;
	
	@Override
	public UserEntity loadUserByUsername(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public boolean register(String username, String password, String email, String phone) {
		UserEntity user=new UserEntity(username,password,email,phone);
		if(userDao.findByUserName(username) == null && userDao.findByEmail(email) == null && userDao.findByPhone(phone) == null){
			try{
				userDao.save(user);
				return true;
			}
			catch(Exception e){
				return false;
			}
		}
		else return false;
	}

	@Override
	public boolean setAvatar(String avatar) {
		return false;
	}

	@Override
	public boolean setDetailedInfo(int id, String nickname, String address, String signature) {
		try{
			UserEntity user=userDao.getRef(id);
			user.setNickname(nickname);
			user.setAddress(address);
			user.setSignature(signature);
			userDao.save(user);
		}
		catch(Exception e){
			return false;
		}
		return false;
	}

	@Override
	public UserEntity loadUserById(int id) {
		return userDao.getRef(id);
	}

	@Override
	public String register(String username, String password, String email, String phone, String nickname,
			String address, String signature, String gender) {
		if(userDao.findByEmail(email)!=null)return "This email has registered.";
		if(userDao.findByNickname(nickname)!=null)return "This nickname has been used.";
		if(userDao.findByUserName(username)!=null)return "This username has beeen registered.";
		if(userDao.findByPhone(phone)!=null)return "This phone has been registered.";
		UserEntity user = new UserEntity(username,password,email,phone,nickname,signature,address,gender);
		try{
			userDao.save(user);
		}
		catch(Exception e){
			return e.getMessage();
		}
		return "success";
	}

}
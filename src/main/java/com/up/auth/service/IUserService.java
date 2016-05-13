package com.up.auth.service;

import com.up.model.UserEntity;

public interface IUserService {
	UserEntity loadUserByUsername(String username);
	UserEntity loadUserById(int id);
	boolean register(String username, String password, String email, String phone);
	boolean setAvatar(String avatar);
	boolean setDetailedInfo(int id, String nickname, String address, String signature);
	String register(String username, String password, String email, String phone, String nickname, String address, String signature, String gender);
}

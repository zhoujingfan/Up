package com.up.auth.service;

import com.up.model.UserEntity;

public interface IUserService {
	UserEntity loadUserByUsername(String username);
	void register(String username, String password, String email, String phone, String nickname, String address, String signature, String gender);
	void setAvatar(String username, String destUri);
}

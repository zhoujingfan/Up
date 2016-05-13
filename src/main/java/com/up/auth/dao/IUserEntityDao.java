package com.up.auth.dao;

import com.up.model.UserEntity;

public interface IUserEntityDao {
	UserEntity get(int id);
	UserEntity getRef(int id);
	void save(UserEntity user);
	UserEntity findByUserName(String username);
	UserEntity findByNickname(String nickname);
	UserEntity findByPhone(String phone);
	UserEntity findByEmail(String email);
}

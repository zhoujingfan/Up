package com.up.search.service;

import java.util.List;

import com.up.model.UserEntity;

public interface ISearchService {
	public List<UserEntity> searchUserByNickname(String nickname);
}

package com.up.search.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.dao.IBaseDao;
import com.up.model.UserEntity;
import com.up.model.WeiboEntity;
import com.up.search.service.ISearchService;

@Service("searchService")
public class SearchService implements ISearchService {
	
	@Autowired
	private IBaseDao<WeiboEntity> weiboDao;
	
	@Autowired
	private IBaseDao<UserEntity> userDao;

	@Override
	public List<UserEntity> searchUserByNickname(String nickname) {
		return userDao.find("from UserEntity where nickname like '%"+nickname+"%'");
	}
	
}

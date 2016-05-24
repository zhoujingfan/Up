package com.up.weibo.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.up.dao.IBaseDao;
import com.up.model.UserEntity;
import com.up.model.WeiboEntity;
import com.up.weibo.service.IWeiboService;

public class WeiboService implements IWeiboService {
	
	@Autowired
	private IBaseDao<WeiboEntity> weiboDao;
	
	@Autowired
	private IBaseDao<UserEntity> userDao;

	@Override
	public void publish(String username, String content) {
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		UserEntity user = userDao.get("from UserEntity where username=?", param);
		WeiboEntity weibo = new WeiboEntity();
		weibo.setUserEntity(user);
		weibo.setTime(new Timestamp(new Date().getTime()));
		weibo.setContent(content);
		weiboDao.save(weibo);
	}

	@Override
	public List<WeiboEntity> getWeibo(String username) {
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		return weiboDao.find("from WeiboEntity w where w.userEntity.username=?", param);
	}

	@Override
	public int getWeiboAmount(String username) {
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		return weiboDao.executeHql("select count(w) from WeiboEntity w where w.userEntity.username=?", param);
	}

}

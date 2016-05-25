package com.up.follow.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.up.follow.service.*;
import com.up.model.FollowEntity;
import com.up.model.UserEntity;
import com.up.follow.dao.IFollowDao;
import com.up.follow.dao.impl.FollowDao;
import com.up.auth.dao.IUserEntityDao;
import com.up.auth.dao.impl.UserEntityDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("FollowService")
public class FollowService {
	@Autowired
	private IUserEntityDao iuserEntityDao;	
	
	@Autowired
	private IFollowDao followDao;
	int userId;
	private List<FollowEntity> followEntity = new ArrayList<FollowEntity>();
	private List<String> users = new ArrayList<String>();
	public void addFollow(String userName, String followUserName){
		UserEntity userEntity = iuserEntityDao.findByUserName(userName);
		UserEntity use_follow  = iuserEntityDao.findByUserName(followUserName);
		FollowEntity saveFollow = new FollowEntity();
		saveFollow.setUserEntityByFollowUserId(use_follow);
		saveFollow.setUserEntityByUserId(userEntity);
		followDao.save(saveFollow);
	}
	
	public List<FollowEntity> findFollowByUser(String username){
		UserEntity userEntity = iuserEntityDao.findByUserName(username);
		userId  = userEntity.getId();
		followEntity = followDao.findFollowByUser(userId);
//
//		for(int i=0;i < followEntity.size();i++){
//			follow = followEntity.get(i);
//			followusers.add(follow.getUserEntityByFollowUserId().getUsername());
//		}
//
//		System.out.println(followusers);
		return followEntity;
	}

	public List<String> findFollowByFollowUser(String username){
		UserEntity userEntity = iuserEntityDao.findByUserName(username);
		FollowEntity follow = new FollowEntity();
		UserEntity newuser = new UserEntity();
		List<String> followusers = new ArrayList<String>();
		userId  = userEntity.getId();
		followEntity = followDao.findFollowByFollowUser(userId);
		for(int i=0;i < followEntity.size();i++){
			follow = followEntity.get(i);
			followusers.add(follow.getUserEntityByUserId().getUsername());
		}
		return followusers;
	}
	
	public void deleteFollowByUsername(String username){
		UserEntity userEntity = iuserEntityDao.findByUserName(username);
	}
	
	

}

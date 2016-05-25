package com.up.follow.action;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.up.auth.dao.IUserEntityDao;
import com.up.follow.dao.IFollowDao;
import com.up.model.FollowEntity;
import com.up.model.UserEntity;
import com.up.follow.service.impl.FollowService;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class FollowAction  extends ActionSupport{

	private UserEntity followuser;
	@Autowired
	private IUserEntityDao iuserEntityDao;	
	private String username;
	private String followUserName;
	@Autowired
	private FollowService followservice;

	@Autowired
	private IFollowDao followDao;
	
	private String message;
	
	private List<String> follownames = new ArrayList<String>();
	private List<FollowEntity> followEntity = new ArrayList<FollowEntity>();
	
	
	public void setFollownames(List<String> follownames){
		this.follownames = follownames;
	}

	public void setMessage(){
		this.message =null;
	};
	public void setMessage(String message){
		this.message=message;
	}
	
	public String getMessage(){
		return this.message;
	}
	public List<String> getFollownames(){
		return this.follownames;
	}
	public void setUsername(String userName){
		this.username = userName;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setFollowUserName(String followUserName){
		this.followUserName = followUserName;
	}
	
	public String getFollowUserName(){
		return this.followUserName;
	}
	public String execute(){
		FollowEntity follow = new FollowEntity();
		followservice = new FollowService();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String namess=null;
		if (principal instanceof UserDetails) {
			namess = ((UserDetails)principal).getUsername();
		} else {
			namess = principal.toString();
		}
		UserEntity user_A = iuserEntityDao.findByUserName(namess);
		
		followuser = iuserEntityDao.findByUserName(getUsername());
		if(followuser == null){
			show();
			setMessage("这个用户不存在");
			return "nouser";
		}
		if(namess.equals(followuser.getUsername())){
			show();
			setMessage("你不能关注你自己");
			return SUCCESS;
		}
		followEntity = followDao.findFollowByUser(user_A.getId());
		for(int i =0;i<followEntity.size();i++){
			follow = followEntity.get(i);
			followuser = follow.getUserEntityByFollowUserId();
			if(getUsername().equals(followuser.getUsername())){
				setMessage("你已经关注了这个用户");
				show();
				return  "exist";
			}
		}
		UserEntity use_follow  = iuserEntityDao.findByUserName(getUsername());
		FollowEntity saveFollow = new FollowEntity();
		saveFollow.setUserEntityByFollowUserId(use_follow);
		saveFollow.setUserEntityByUserId(user_A);
		followDao.save(saveFollow);
		show();
		setMessage("关注成功");
		return SUCCESS;
	}  
	public void show(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String namess=null;
		if (principal instanceof UserDetails) {
			namess = ((UserDetails)principal).getUsername();
		} else {
			namess = principal.toString();
		}
		UserEntity user_A = iuserEntityDao.findByUserName(namess);
		followEntity = followDao.findFollowByUser(user_A.getId());
		FollowEntity follow = new FollowEntity();
		for(int i=0;i<followEntity.size();i++){
			follow = followEntity.get(i);
			follownames.add(follow.getUserEntityByFollowUserId().getUsername());
		}
	}
	
	public String ListFollow(){
		show();
		setMessage();
		return SUCCESS;
	}
	
	public String delete(){
		
		return SUCCESS;
	}
}

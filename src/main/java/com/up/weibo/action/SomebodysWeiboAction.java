package com.up.weibo.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.opensymphony.xwork2.ActionSupport;
import com.up.model.WeiboEntity;
import com.up.weibo.service.IWeiboService;

public class SomebodysWeiboAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<WeiboEntity> weiboList;
	private String nickname;
	@Autowired
	private IWeiboService weiboService;
	public List<WeiboEntity> getWeiboList() {
		return weiboList;
	}
	public void setWeiboList(List<WeiboEntity> weiboList) {
		this.weiboList = weiboList;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String execute() throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		weiboList = weiboService.getFollowUserWeibo(username);
		return SUCCESS;
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
	
	
}

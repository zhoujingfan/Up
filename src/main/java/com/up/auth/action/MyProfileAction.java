package com.up.auth.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.opensymphony.xwork2.ActionSupport;
import com.up.auth.service.IUserService;
import com.up.model.UserEntity;
import com.up.weibo.service.IWeiboService;

public class MyProfileAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IWeiboService weiboService;
	@Autowired
	private IUserService userService;
	
	private UserEntity user;
	private Long weiboAmount;
	
	@Override
	public String execute() throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		user=userService.loadUserByUsername(username);
		weiboAmount = weiboService.getWeiboAmount(username);
		return SUCCESS;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Long getWeiboAmount() {
		return weiboAmount;
	}

	public void setWeiboAmount(Long weiboAmount) {
		this.weiboAmount = weiboAmount;
	}

}

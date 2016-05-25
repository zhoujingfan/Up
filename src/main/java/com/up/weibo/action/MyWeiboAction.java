package com.up.weibo.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.opensymphony.xwork2.ActionSupport;
import com.up.model.WeiboEntity;
import com.up.weibo.service.IWeiboService;

public class MyWeiboAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<WeiboEntity> weiboList;
	private List<String> contentList;
	@Autowired
	private IWeiboService weiboService;

	public List<WeiboEntity> getWeiboList() {
		return weiboList;
	}

	public void setWeiboList(List<WeiboEntity> weiboList) {
		this.weiboList = weiboList;
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
		weiboList = weiboService.getWeiboByUsername(username);
		contentList = new ArrayList<String>();
		for(WeiboEntity w:weiboList){
			contentList.add(w.getContent());
		}
		return SUCCESS;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	public List<String> getContentList() {
		return contentList;
	}

	public void setContentList(List<String> contentList) {
		this.contentList = contentList;
	}
}

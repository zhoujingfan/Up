package com.up.search.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.up.model.UserEntity;
import com.up.search.service.impl.SearchService;

public class SearchUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;
	private List<UserEntity> resultList;
	@Autowired
	private SearchService searchService;

	@Override
	public String execute() throws Exception {
		resultList = searchService.searchUserByNickname(keyword);
		return SUCCESS;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	public List<UserEntity> getResultList() {
		return resultList;
	}

	public void setResultList(List<UserEntity> resultList) {
		this.resultList = resultList;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}

package com.up.comment.action;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.opensymphony.xwork2.ActionSupport;
import com.up.auth.service.IUserService;
import com.up.comment.service.impl.ICommentService;
import com.up.model.UserEntity;
import com.up.model.CommentEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;        
import net.sf.json.JsonConfig;        
import net.sf.json.util.CycleDetectionStrategy; 

import org.json.*;

public class LoadCommentAction extends ActionSupport{
	/**
	 * 这是获取某个微博的评论,每次10条
	 */
	private String content;
	private int publisher_id;
	private String publisher_name;
	private int weibo_id;
	private Timestamp time;
	private int page_index;
	/**
	 * 获取CommentService对象
	 */
	@Autowired
	ICommentService commentService;

	public String getContent() {
		return content;
	}

	public void setUsername(String content) {
		this.content = content;
	}
	
	public String getPublisherName() {
		return publisher_name;
	}
	
	public void setPublisherName(String name) {
		this.publisher_name = name;
	}
	
	public int getPublisherID() {
		return publisher_id;
	}

	public void setPublisherID(int id) {
		this.publisher_id = id;
	}
	
	public int getWeiboID() {
		return weibo_id;
	}

	public void setWeiboID(int id) {
		this.weibo_id = id;
	}
	
	@SuppressWarnings("deprecation")
	public Timestamp getTime() {
		return time;
	}
	public void setTime(){
		Date date = new Date();      
		this.time = new Timestamp(date.getTime());
	}
	public int getPageIndex(){
		return page_index;
	}
	public void setPageIndex(int page){
		this.page_index = page;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception{	
		Map map = new HashMap();

		List<CommentEntity> arr;
		if(getContent()==null)return INPUT;
		arr = (List<CommentEntity>) commentService.loadComment(getWeiboID(), getPageIndex());//arr里有10个commentEntity
		if(arr!= null){
			map.put("arr",arr);
			GenerateJson(map);//生成json
			return SUCCESS;
		}
		return INPUT;
	}

	@Override
	public void validate(){
		if(getContent()==null)
			return;
		if(getContent().length()==0){
			addFieldError("comment", "Comment is required.");
		}
		super.validate();
	}

	@Override
	public String input() throws Exception {
		return super.input();
	}
	
	public void GenerateJson(Map map) throws JSONException{  
		JSONObject json = JSONObject.fromObject(map);
	    System.out.println(json.toString());
	}  

}
	
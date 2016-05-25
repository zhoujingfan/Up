package com.up.comment.action;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.opensymphony.xwork2.ActionSupport;
import com.up.auth.service.IUserService;
import com.up.comment.service.impl.ICommentService;
import com.up.model.UserEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.up.model.CommentEntity;


@SuppressWarnings("serial")
public class SubmitCommentAction extends ActionSupport{
	/**
	 * 这是新增评论 
	 */
	private String content;
	private int publisher_id;
	private String publisher_name;
	private int weibo_id;
	private Timestamp time;
	/**
	 * 获取CommentService对象
	 */
	@Autowired
	ICommentService commentService;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
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

	@Override
	public String execute() throws Exception{
		String jsonStr = ServletActionContext.getRequest().getParameter("mydata");
		
		//解析json
		JSONArray jsonArray = JSONArray.fromObject(jsonStr);

		JSONObject jsonJ = jsonArray.getJSONObject(0);//只传一行

		setContent(jsonJ.getString("content"));
		
		setWeiboID(jsonJ.getInt("weibo_id"));
		
		setPublisherID(jsonJ.getInt("publisher_id"));

		if(getContent()==null)return INPUT;
		if(commentService.submitComment(getContent(),  getTime(), getPublisherID(), getWeiboID()))return SUCCESS;
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
	
	public static void ParseJson(String jsonString) throws JSONException,ParseException {//接收前端传来的json
		
		//jsonJ.getString("age");

	}
}
	
package com.up.comment.service;

import java.sql.Timestamp;
import java.util.List;

import com.up.auth.dao.IUserEntityDao;
import com.up.comment.dao.impl.ICommentEntityDao;
import com.up.model.CommentEntity;

public class CommentService {
	private ICommentEntityDao commentDao;

	//提交评论
	public boolean submitComment(String contnet, Timestamp timestamp, int user_id, int weibo_id) {
		CommentEntity comment = new CommentEntity();	
			try{
				commentDao.save(comment);
				return true;
			}
			catch(Exception e){
				return false;
			}
	}
	
	//加载所有评论
	public Object loadComment(int weibo_id, int page_index) {
		List<CommentEntity> commentList;	
			try{
				commentList = commentDao.findByWeiboID(weibo_id, page_index);
				return commentList;
			}
			catch(Exception e){
				return e;
			}
	}
}

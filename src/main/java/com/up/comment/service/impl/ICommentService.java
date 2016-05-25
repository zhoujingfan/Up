package com.up.comment.service.impl;

import java.sql.Timestamp;

public interface ICommentService {
	boolean submitComment(String contnet, Timestamp timestamp, int user_id, int weibo_id);//提交评论
	Object loadComment(int weibo_id, int page_index);//加载评论
}

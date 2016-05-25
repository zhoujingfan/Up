package com.up.comment.dao.impl;

import java.util.List;

import com.up.model.CommentEntity;

public interface ICommentEntityDao {
	public void save(CommentEntity comment);
	public List<CommentEntity> findByWeiboID(int weibo_id, int page_index);
}

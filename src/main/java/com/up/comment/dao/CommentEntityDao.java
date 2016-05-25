package com.up.comment.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.up.comment.dao.impl.ICommentEntityDao;
import com.up.model.CommentEntity;
import com.up.model.UserEntity;

/**
 * ICommentDao接口的实现
 * @author fyh
 *
 */
public class CommentEntityDao implements ICommentEntityDao{
	private SessionFactory sessionFactory;

	/**
	 * 相当于insert语句，在数据库中创建一个新的comment
	 */
	@Override
	public void save(CommentEntity comment) {
		sessionFactory.getCurrentSession().save(comment);
	}
	
	
	/**
	 * select * from Comment where weibo=?，返回评论entity的一个list
	 */
	@SuppressWarnings("unchecked")
	public List<CommentEntity> findByWeiboID(int weibo_id, int page_index) {
		List<CommentEntity> comments = new ArrayList<CommentEntity>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Comment where weibo=?");
		if(page_index>0){
		query.setFirstResult(page_index * 10 - 9);
		query.setMaxResults(10);//读10条
		}
		comments = query.setParameter(0, weibo_id).list();
		if (comments.size() > 0) {
			return comments;
		} else {
			return null;
		}
	}
}

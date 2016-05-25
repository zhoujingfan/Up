package com.up.follow.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.up.model.FollowEntity;
import com.up.model.UserEntity;
import com.up.follow.dao.IFollowDao;

@Repository
@Transactional
public class FollowDao implements IFollowDao{
	

	List<FollowEntity> followEntity = new ArrayList<FollowEntity>();
	@Autowired
	private SessionFactory sessionFactory;
	public void save(FollowEntity followEntity){
		sessionFactory.getCurrentSession().save(followEntity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FollowEntity> findFollowByUser(int userId) {
		// TODO Auto-generated method stub
		followEntity = sessionFactory.getCurrentSession()
				.createQuery("from FollowEntity where user_id=?")
				.setParameter(0, userId)
				.list();
		return followEntity;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FollowEntity> findFollowByFollowUser(int userId) {
		// TODO Auto-generated method stub
		followEntity = sessionFactory.getCurrentSession()
				.createQuery("from FollowEntity where follow_user_id = ?")
				.setParameter(0, userId)
				.list();
		
		return followEntity;
	}
	@Override
	public void deleteFollow(int user_id, int follow_user_id) {
		// TODO Auto-generated method stub
		String sql = "delete from FollowEntity where follow_user_id = " + follow_user_id + " && user_id = " + user_id;
		sessionFactory.getCurrentSession().createSQLQuery(sql);
	}
	@Override
	public int getFollowNum(int userId) {
		// TODO Auto-generated method stub
		return findFollowByUser(userId).size();
	}
	@Override
	public int getFansNum(int userId) {
		// TODO Auto-generated method stub
		return findFollowByFollowUser(userId).size();
	}
	
}

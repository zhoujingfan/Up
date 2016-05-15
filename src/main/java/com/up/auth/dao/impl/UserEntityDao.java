package com.up.auth.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.up.auth.dao.IUserEntityDao;
import com.up.model.UserEntity;

/**
 * IUserDao接口的实现
 * 实际上这两个文件也可以命名为IUserRepository和UserRepository，因为都是用了Repository的Annotation
 * @author tyche
 *
 */
@Repository
@Transactional
public class UserEntityDao implements IUserEntityDao {
	
	/**
	 * 获取在Application.java文件当中的Bean，调用UserDao中的函数时该对象会自动的生成
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 相当于insert语句，在数据库中创建一个新的User
	 */
	@Override
	public void save(UserEntity user) {
		sessionFactory.getCurrentSession().save(user);
	}

	/**
	 * select * from User where username=?，返回结果中的第一个对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UserEntity findByUserName(String username) {
		List<UserEntity> users = new ArrayList<UserEntity>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from UserEntity where username=?")
			.setParameter(0, username)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity findByNickname(String nickname) {
		List<UserEntity> users = new ArrayList<UserEntity>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from UserEntity where nickname=?")
			.setParameter(0, nickname)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity findByPhone(String phone) {
		List<UserEntity> users = new ArrayList<UserEntity>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from UserEntity where phone=?")
			.setParameter(0, phone)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity findByEmail(String email) {
		List<UserEntity> users = new ArrayList<UserEntity>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from UserEntity where email=?")
			.setParameter(0, email)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public UserEntity get(int id) {
		return (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, id);
	}

	@Override
	public UserEntity getRef(int id) {
		return (UserEntity) sessionFactory.getCurrentSession().load(UserEntity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean hasAvatar(String username) {
		List<UserEntity> users = new ArrayList<UserEntity>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from UserEntity where username=? and avatar is not null")
			.setParameter(0, username)
			.list();

		if (users.size() == 1) {
			return true;
		} else {
			return false;
		}
	}
}

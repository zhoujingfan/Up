package com.up.auth.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.up.auth.dao.IUserEntityDao;
import com.up.model.RoleEntity;
import com.up.model.UserEntity;

@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	//get user from the database, via Hibernate
	@Autowired
	private IUserEntityDao userDao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
	
		UserEntity user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getRoleEntities());

		return buildUserForAuthentication(user, authorities);
		
	}

	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.up.model.UserEntity user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPasswordHash(), 
			true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<RoleEntity> set) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (@SuppressWarnings("unused") RoleEntity userRole : set) {
			setAuths.add(new SimpleGrantedAuthority("1"));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}
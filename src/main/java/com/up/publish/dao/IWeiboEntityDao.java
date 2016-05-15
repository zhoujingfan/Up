package com.up.publish.dao;

import com.up.model.UserEntity;

public interface IWeiboEntityDao {
	public String publishOnlyContent(UserEntity user, String content);
}

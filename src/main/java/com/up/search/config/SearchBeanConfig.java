package com.up.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.up.search.action.SearchUserAction;

@Configuration
public class SearchBeanConfig {
	@Bean
	public SearchUserAction searchUserAction(){
		return new SearchUserAction();
	}
}

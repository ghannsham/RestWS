package com.spring.security.mapper;

import org.mapstruct.factory.Mappers;

public class AppMapper {

	public AppMapper() {
		// TODO Auto-generated constructor stub
	}
	public static final AppUserMapper APP_USER_MAPPER = Mappers.getMapper(AppUserMapper.class);
}

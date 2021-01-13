package com.spring.security.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.security.dto.testdb.UserPermissionGroupDto;
import com.spring.security.entity.testdb.UserPermissionGroup;

@Mapper
public interface UserPermissionGroupMapper {

	@Mapping(target = "userId", source = "user.id")
	UserPermissionGroupDto entityToDto(UserPermissionGroup entity);
	List<UserPermissionGroupDto> entityToDto(List<UserPermissionGroup> entity);
	
	@InheritInverseConfiguration
	UserPermissionGroup dtoToEntity(UserPermissionGroupDto dto);
	List<UserPermissionGroup> dtoToEntity(List<UserPermissionGroupDto> dto);
}

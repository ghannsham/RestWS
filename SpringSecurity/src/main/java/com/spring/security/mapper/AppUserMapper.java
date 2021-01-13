package com.spring.security.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.security.dto.testdb.AppUserDto;
import com.spring.security.entity.testdb.AppUser;

@Mapper(uses = {UserPermissionGroupMapper.class})
public interface AppUserMapper {

	@Mapping(target = "userId", source = "id")
	@Mapping(target = "email", source = "email")
	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "password", source = "password")
	@Mapping(target = "username", source = "username")
	@Mapping(target = "userPermissionGroups", source = "userPermissionGroups")
	AppUserDto entityToDto(AppUser entity);
	List<AppUserDto> entityToDto(List<AppUser> entity);
	
	@InheritInverseConfiguration
	AppUser dtoToEntity(AppUserDto dto);
	List<AppUser> dtoToEntity(List<AppUserDto> dto);
}

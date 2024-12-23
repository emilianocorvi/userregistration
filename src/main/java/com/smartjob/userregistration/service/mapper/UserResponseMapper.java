package com.smartjob.userregistration.service.mapper;

import org.mapstruct.Mapper;

import com.smartjob.userregistration.model.User;
import com.smartjob.userregistration.service.dto.UserResponseDto;

@Mapper(componentModel = "spring", uses = {})
public interface UserResponseMapper extends EntityMapper<UserResponseDto, User> {

}

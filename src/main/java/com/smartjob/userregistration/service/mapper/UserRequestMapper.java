package com.smartjob.userregistration.service.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.smartjob.userregistration.model.User;
import com.smartjob.userregistration.service.dto.UserRequestDto;

@Service
public class UserRequestMapper implements EntityMapper<UserRequestDto, User> {

	private final PhoneMapper phoneMapper;

	public UserRequestMapper(PhoneMapper phoneMapper) {
		this.phoneMapper = phoneMapper;
	}

	@Override
	public User toEntity(UserRequestDto dto) {
		User user = new User();
		user.setCreated(LocalDateTime.now());
		user.setModified(LocalDateTime.now());
		user.setLastLogin(LocalDateTime.now());
		user.setToken(UUID.randomUUID().toString());
		user.setActive(true);

		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setPhones(phoneMapper.toEntity(dto.getPhones()));

		return user;
	}

	@Override
	public UserRequestDto toDto(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> toEntity(List<UserRequestDto> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRequestDto> toDto(List<User> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}

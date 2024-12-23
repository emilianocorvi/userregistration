package com.smartjob.userregistration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartjob.userregistration.model.User;
import com.smartjob.userregistration.repository.UserRepository;
import com.smartjob.userregistration.service.dto.UserRequestDto;
import com.smartjob.userregistration.service.dto.UserResponseDto;
import com.smartjob.userregistration.service.mapper.UserRequestMapper;
import com.smartjob.userregistration.service.mapper.UserResponseMapper;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserRequestMapper userRequestMapper;
	private final UserResponseMapper userResponseMapper;

	public UserService(UserRepository userRepository, UserRequestMapper userMapper,
			UserResponseMapper userResponseMapper) {
		this.userRepository = userRepository;
		this.userRequestMapper = userMapper;
		this.userResponseMapper = userResponseMapper;
	}

	public UserResponseDto registerUser(UserRequestDto dtoRequest) {
		if (userRepository.existsByEmail(dtoRequest.getEmail())) {
			throw new IllegalArgumentException("El correo ya registrado");
		}
		User user = userRequestMapper.toEntity(dtoRequest);
		UserResponseDto dtoResponse = userResponseMapper.toDto(userRepository.save(user));
		return dtoResponse;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}

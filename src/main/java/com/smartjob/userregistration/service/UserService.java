package com.smartjob.userregistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
		User user = userRequestMapper.toEntity(dtoRequest);
		UserResponseDto dtoResponse = userResponseMapper.toDto(userRepository.save(user));
		return dtoResponse;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) throws NotFoundException {
		Optional<User> userOpt = userRepository.findById(id);
		if (!userOpt.isPresent()) {
			throw new NotFoundException();
		}
		return userOpt.get();
	}

	public boolean isEmailRegistered(String email) {
		return userRepository.existsByEmail(email);
	}

}

package com.smartjob.userregistration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.smartjob.userregistration.model.User;
import com.smartjob.userregistration.repository.UserRepository;
import com.smartjob.userregistration.service.UserService;
import com.smartjob.userregistration.service.dto.PhoneDto;
import com.smartjob.userregistration.service.dto.UserRequestDto;
import com.smartjob.userregistration.service.dto.UserResponseDto;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	private UserRequestDto dtoRequest;

	@BeforeEach
	public void createUser() {
		dtoRequest = new UserRequestDto();
		dtoRequest.setEmail("emiliano.corvi@gmail.com");
		dtoRequest.setName("Emiliano");
		dtoRequest.setPassword("password123");

		PhoneDto phone = new PhoneDto();
		phone.setCityCode("111");
		phone.setContryCode("222222");
		phone.setNumber("333333333");
		dtoRequest.setPhones(Collections.singletonList(phone));
	}

	@Test
	public void testRegisterUser_Success() {
		Mockito.when(userRepository.existsByEmail("emiliano.corvi@gmail.com")).thenReturn(false);
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenAnswer(invocation -> {
			User savedUser = invocation.getArgument(0);
			savedUser.setId(1L);
			savedUser.setCreated(LocalDateTime.now());
			return savedUser;
		});

		UserResponseDto result = userService.registerUser(dtoRequest);

		assertNotNull(result.getId());
	}

	@Test
	public void testRegisterUser_EmailAlreadyExists() {

		Mockito.when(userRepository.existsByEmail("emiliano.corvi@gmail.com")).thenReturn(true);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			userService.registerUser(dtoRequest);
		});

		assertEquals("El correo ya registrado", exception.getMessage());
	}
}

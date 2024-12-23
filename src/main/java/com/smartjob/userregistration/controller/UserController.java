package com.smartjob.userregistration.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjob.userregistration.errors.Respuesta;
import com.smartjob.userregistration.model.User;
import com.smartjob.userregistration.service.UserService;
import com.smartjob.userregistration.service.dto.UserRequestDto;
import com.smartjob.userregistration.service.dto.UserResponseDto;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDto userDto, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return ResponseEntity.badRequest()
						.body(new Respuesta(result.getAllErrors().get(0).getDefaultMessage()));
			}
			UserResponseDto createdUser = userService.registerUser(userDto);
			return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
	}

	@GetMapping("")
	public ResponseEntity<?> registerUser() {
		try {
			return ResponseEntity.ok().body(userService.findAll());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
	}

}

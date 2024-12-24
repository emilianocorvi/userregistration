package com.smartjob.userregistration.controller;

import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjob.userregistration.errors.Respuesta;
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
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(new Respuesta(result.getAllErrors().get(0).getDefaultMessage()));
		}
		if (userService.isEmailRegistered(userDto.getEmail())) {
			return ResponseEntity.badRequest().body(new Respuesta("El correo ya registrado"));
		}

		UserResponseDto createdUser = userService.registerUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	@GetMapping("")
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok().body(userService.findAll());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new Respuesta(e.getMessage()));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable(value = "id") Long id) {
		try {
			return ResponseEntity.ok().body(userService.findById(id));
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario consultado no existe");
		}
	}

}

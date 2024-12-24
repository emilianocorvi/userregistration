package com.smartjob.userregistration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjob.userregistration.service.PhoneService;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

	private final PhoneService phoneService;

	public PhoneController(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	@GetMapping("")
	public ResponseEntity<?> registerUser() {
		return ResponseEntity.ok().body(phoneService.findAll());
	}

}

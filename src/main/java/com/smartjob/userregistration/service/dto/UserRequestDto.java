package com.smartjob.userregistration.service.dto;

import java.util.List;

import javax.validation.constraints.Pattern;

import com.smartjob.userregistration.annotation.Password;

public class UserRequestDto {

	private String name;

	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Formato de email inválido: aaaaaa@dominio.cl")
	private String email;

	@Password
	private String password;

	private List<PhoneDto> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneDto> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDto> phones) {
		this.phones = phones;
	}

}
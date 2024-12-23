package com.smartjob.userregistration.service.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponseDto {

	private UUID id;

	private LocalDateTime created;

	private LocalDateTime modified;

	@JsonProperty("last_login")
	private LocalDateTime lastLogin;

	private String token;

	@JsonProperty("isactive")
	private boolean active;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean active() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
package com.smartjob.userregistration.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneDto {

	private String number;

	@JsonProperty("citycode")
	private String cityCode;

	@JsonProperty("contrycode")
	private String contryCode;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getContryCode() {
		return contryCode;
	}

	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}

}
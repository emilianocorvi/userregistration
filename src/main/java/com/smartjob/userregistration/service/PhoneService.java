package com.smartjob.userregistration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartjob.userregistration.model.Phone;
import com.smartjob.userregistration.repository.PhoneRepository;

@Service
public class PhoneService {

	private final PhoneRepository phoneRepository;

	public PhoneService(PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}

	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}

}

package com.smartjob.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjob.userregistration.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}

package com.smartjob.userregistration.service.mapper;

import org.mapstruct.Mapper;

import com.smartjob.userregistration.model.Phone;
import com.smartjob.userregistration.service.dto.PhoneDto;

@Mapper(componentModel = "spring", uses = {})
public interface PhoneMapper extends EntityMapper<PhoneDto, Phone> {

}

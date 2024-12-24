package com.smartjob.userregistration.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.smartjob.userregistration.model.Phone;
import com.smartjob.userregistration.model.User;
import com.smartjob.userregistration.service.dto.PhoneDto;

@Mapper(componentModel = "spring", uses = {})
public interface PhoneMapper extends EntityMapper<PhoneDto, Phone> {

	default List<Phone> toEntities(User user, List<PhoneDto> dtos) {
		List<Phone> entities = toEntity(dtos);
		entities.forEach(p -> p.setUser(user));
		return entities;
	}

}

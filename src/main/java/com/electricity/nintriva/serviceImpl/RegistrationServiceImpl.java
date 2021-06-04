package com.electricity.nintriva.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.nintriva.dto.UserDto;
import com.electricity.nintriva.entity.RegistrationEntity;
import com.electricity.nintriva.repository.RegistrationRepository;
import com.electricity.nintriva.service.RegistrationService;
import com.electricity.nintriva.shared.Utils;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	
	@Autowired
	RegistrationRepository regrep;
	@Autowired
	Utils utils;
	
	@Override
	public UserDto registerUser(UserDto userDto) {
		UserDto backtoUserDto=new UserDto();
		RegistrationEntity regEntity=new RegistrationEntity();
		
		BeanUtils.copyProperties(userDto, regEntity);
		String publicUserId=utils.generateUserId(25);
		regEntity.setPublicUserId(publicUserId);
		            RegistrationEntity reg=   regrep.save(regEntity);
		            BeanUtils.copyProperties(reg,backtoUserDto);
		return backtoUserDto;
	}

}

package com.electricity.nintriva.serviceImpl;

import ch.qos.logback.classic.jmx.MBeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.electricity.nintriva.dto.UserDto;
import com.electricity.nintriva.entity.RegistrationEntity;
import com.electricity.nintriva.repository.RegistrationRepository;
import com.electricity.nintriva.service.RegistrationService;
import com.electricity.nintriva.shared.Utils;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	
	@Autowired
	RegistrationRepository regrep;

	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserDto registerUser(UserDto userDto) {
		UserDto backtoUserDto=new UserDto();
		RegistrationEntity regEntity=new RegistrationEntity();
		
		BeanUtils.copyProperties(userDto, regEntity);
		String publicUserId=utils.generateUserId(25);
		regEntity.setPublicUserId(publicUserId);
		if(regrep.findByEmail(userDto.getEmail())!=null) throw new RuntimeException("Record already exists "+ userDto.email);
		if(regrep.findByConsumerNumber(userDto.getConsumerNumber())!=null) throw new RuntimeException("Consumer already registered "+userDto.getConsumerNumber());
		regEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		            RegistrationEntity reg=   regrep.save(regEntity);
		            BeanUtils.copyProperties(reg,backtoUserDto);
		return backtoUserDto;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		RegistrationEntity dbUserDetails = regrep.findByEmail(email);
		if(Objects.isNull(dbUserDetails)) throw new RuntimeException("User not found");
		return new User(dbUserDetails.getEmail(),dbUserDetails.getEncryptedPassword(),new ArrayList<>());
	}

	public UserDto getUser(String email){
		    RegistrationEntity user = regrep.findByEmail(email);
		    UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user,userDto);
		return userDto;

	}
}

package com.electricity.nintriva.service;

import com.electricity.nintriva.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface RegistrationService extends UserDetailsService {
	
	public UserDto registerUser(UserDto userDto);
	public UserDto getUser(String email);
	
	
	

	
	
}

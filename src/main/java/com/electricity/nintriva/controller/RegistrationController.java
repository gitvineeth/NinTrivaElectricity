package com.electricity.nintriva.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.nintriva.dto.UserDto;
import com.electricity.nintriva.model.CustomerRegisterModel;
import com.electricity.nintriva.response.RegistrationResponse;
import com.electricity.nintriva.service.RegistrationService;

@RestController
public class RegistrationController {
	
	
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping("/register")
	
		public RegistrationResponse saveUser(@RequestBody CustomerRegisterModel srm)
		{
	       RegistrationResponse regresp=new RegistrationResponse();
		     UserDto userDto =new UserDto();
			BeanUtils.copyProperties(srm,userDto);
			System.out.println(userDto.getPublicUserId());
			UserDto registeredUser=registrationService.RegisterUser(userDto);
			System.out.println(registeredUser.getPublicUserId());
			BeanUtils.copyProperties(registeredUser,regresp);
			return regresp;
		}
	}



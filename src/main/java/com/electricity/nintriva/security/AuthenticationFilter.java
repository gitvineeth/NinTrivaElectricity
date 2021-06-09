package com.electricity.nintriva.security;

import com.electricity.nintriva.SpringApplicationContext;
import com.electricity.nintriva.dto.UserDto;
import com.electricity.nintriva.model.UserLoginDetailsModel;
import com.electricity.nintriva.service.RegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {

        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try
        {
            UserLoginDetailsModel creds = new ObjectMapper().readValue(request.getInputStream(),UserLoginDetailsModel.class);
            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(),creds.getPassword(),new ArrayList<>()));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
          String userName =  ((User) auth.getPrincipal()).getUsername();

          String token = Jwts.builder()
                  .setSubject(userName)
                  .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
                  .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                  .compact();
        RegistrationService  regService = (RegistrationService) SpringApplicationContext.getBean("registrationServiceImpl");
        UserDto userDto = regService.getUser(userName);

          response.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+token);
          response.addHeader("UserID",userDto.getPublicUserId());




    }
}

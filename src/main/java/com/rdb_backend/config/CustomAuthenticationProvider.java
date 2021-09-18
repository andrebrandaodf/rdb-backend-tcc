package com.rdb_backend.config;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.rdb_backend.models.User;
import com.rdb_backend.repository.UserRepository;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication auth) {
        String userName = auth.getName();
        String password = auth.getCredentials().toString();

        User userFound = userRepository.findByUsername(userName);

        if (!encoder.matches(password, userFound.getPassword())) {
            throw new BadCredentialsException("Senha Incorreta.");
        }
        
        List<SimpleGrantedAuthority> roles = new ArrayList(); 
        
        if (userFound.getRole() != null && !userFound.getRole().isBlank()) {
        	Arrays.asList(new SimpleGrantedAuthority(userFound.getRole()));         	
        }
        
        return new UsernamePasswordAuthenticationToken(
                userName, password, roles);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}

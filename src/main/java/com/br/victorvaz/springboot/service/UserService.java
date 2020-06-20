package com.br.victorvaz.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.br.victorvaz.springboot.model.User;
import com.br.victorvaz.springboot.web.dto.UserRegistratioDto;

public interface UserService  extends UserDetailsService {
	User save(UserRegistratioDto userRegistratioDto);
	
	
}

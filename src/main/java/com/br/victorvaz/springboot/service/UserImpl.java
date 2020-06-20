package com.br.victorvaz.springboot.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.br.victorvaz.springboot.model.Role;
import com.br.victorvaz.springboot.model.User;
import com.br.victorvaz.springboot.repository.UserRepository;
import com.br.victorvaz.springboot.web.dto.UserRegistratioDto;

@Service
public class UserImpl implements UserService{

	private UserRepository userRepository;
	
	public UserImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistratioDto userRegistratioDto) {
		
		User user = new User(userRegistratioDto.getFirsName(), 
				userRegistratioDto.getLastName(), userRegistratioDto.getEmail(), 
				userRegistratioDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

}

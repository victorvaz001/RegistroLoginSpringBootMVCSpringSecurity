package com.br.victorvaz.springboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.victorvaz.springboot.model.Role;
import com.br.victorvaz.springboot.model.User;
import com.br.victorvaz.springboot.repository.UserRepository;
import com.br.victorvaz.springboot.web.dto.UserRegistratioDto;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistratioDto userRegistratioDto) {
		
		User user = new User(userRegistratioDto.getFirsName(), 
				userRegistratioDto.getLastName(), userRegistratioDto.getEmail(), 
				passwordEncoder.encode(userRegistratioDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<Role> roles){
	return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
	}

}

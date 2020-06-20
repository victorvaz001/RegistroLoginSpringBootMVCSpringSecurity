package com.br.victorvaz.springboot.service;

import com.br.victorvaz.springboot.model.User;
import com.br.victorvaz.springboot.web.dto.UserRegistratioDto;

public interface UserService {
	User save(UserRegistratioDto userRegistratioDto);
	
	
}

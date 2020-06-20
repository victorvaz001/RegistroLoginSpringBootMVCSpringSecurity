package com.br.victorvaz.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.victorvaz.springboot.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	

}

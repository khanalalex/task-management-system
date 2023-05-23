package com.codewithalex.taskmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithalex.taskmanagementsystem.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsernameAndPassword(String un, String psw);


}

package com.example.demo.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {
	
	User create(User user);
	
	List<User> findAll();
	
	Optional<User> findByPhone(String phone);
	
	

}

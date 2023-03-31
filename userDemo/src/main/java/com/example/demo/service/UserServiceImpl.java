package com.example.demo.service;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.interfaces.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService  {
	
	private  UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

    public User saveOneUser(User user){
        return this.repository.save(user);
    }

    public User findOneUser(int userId){
        return this.repository.findById((int) userId).orElseThrow(EntityNotFoundException::new);
    }

    public List<User> findAllUser() {
        return IterableUtils.toList(this.repository.findAll())
                .stream()
                .sorted(Comparator.comparingLong(User::getId))
                .collect(Collectors.toList());
    }

    public void deleteOneUser(int userId) {
        this.repository.deleteById((int) userId);
    }

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findByPhone(String phone) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
    


}
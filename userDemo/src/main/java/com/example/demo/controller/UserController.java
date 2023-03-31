package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.model.User;
import com.example.demo.model.Dtos.RegisterUserDto;
import com.example.demo.service.UserServiceImpl;
import com.example.demo.service.interfaces.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;

	  public UserController(UserService userService) {
	    this.userService = userService;
	  }

	  @PostMapping("/register")
	  public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterUserDto registerUserDto) {
	    User createdUser = userService.create(registerUserDto.toUser());

	    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	  }

	  @GetMapping("/all")
	  public ResponseEntity<List<User>> allUsers() {
	    return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	  }
	

}

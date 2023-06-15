package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dtos.UserRequestDto;
import com.demo.dtos.UserResponseDto;
import com.demo.service.UserService;

@RestController()
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/hello")
	public String greeting() {
		return "hello world";
	}
	@PostMapping()
	public UserResponseDto add(@RequestBody() UserRequestDto userDto) {
		 return userService.addUser(userDto);
	}
	 
	@GetMapping()
	public List<UserResponseDto> getAll() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserResponseDto getOne(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@PutMapping("/update/{id}")
	public UserResponseDto update(@PathVariable("id") int id, @RequestBody() UserRequestDto userDto) {
		return userService.udpateUser(id, userDto);
	}
}

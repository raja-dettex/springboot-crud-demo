package com.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dtos.UserRequestDto;
import com.demo.dtos.UserResponseDto;
import com.demo.exceptions.UserNotFoundException;
import com.demo.models.User;
import com.demo.repository.UserRepository;

import utils.UserUtils;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public UserResponseDto addUser(UserRequestDto userDto) {
		User user = UserUtils.userRequestToUser(userDto);
		return UserUtils.userToUserResponse(userRepository.save(user));
	}
	
	public List<UserResponseDto> getAllUsers() {
		return this.userRepository.findAll().stream().map(UserUtils::userToUserResponse).collect(Collectors.toList());
	}
	
	public UserResponseDto getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("user with id" + id + "not found", 404);
		}
		return UserUtils.userToUserResponse(user.orElse(null));
	}

	public UserResponseDto udpateUser(int id, UserRequestDto userDto) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return addUser(userDto);
	}
}

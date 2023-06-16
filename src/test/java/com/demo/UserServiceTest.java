package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.dtos.UserResponseDto;
import com.demo.models.User;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void TestGetListOfUsers() {
		List<User> users = Stream.of(new User(1, "test", "test@gmail", "testpass", 0), new User(2, "test2", "test2@gmail", "testpass2", 0)).collect(Collectors.toList());
		when(userRepository.findAll()).thenReturn(users);
		List<UserResponseDto> allUsers = userService.getAllUsers();
		assertEquals(2, allUsers.size());
	}
	
	@Test
	public void TestGetUserById() {
		User user = new User(1, "test", "test@gmail", "testpass", 0);

		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		UserResponseDto userById = userService.getUserById(1);
		assertEquals("test", userById.getName());
	}
}

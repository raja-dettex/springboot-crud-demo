package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import com.demo.dtos.UserRequestDto;
import com.demo.dtos.UserResponseDto;
import com.demo.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CrudDemoApplicationTests {
	
	@LocalServerPort
	private int port;
	
	private String baseUrl = "http://localhost";
	
	private static RestTemplate restTemplate;
	
	@Autowired
	private TestH2Repository h2Repo;
	
	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}
	
	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port + "").concat("/users");
	}

	@Test
	public void testAddUser() {
		System.out.println(baseUrl);
		
		UserRequestDto userDto = new UserRequestDto("test", "test@hotmail", "testpass");
		UserResponseDto response = restTemplate.postForObject(baseUrl, userDto, UserResponseDto.class);
		assertEquals("test", response.getName());
		assertEquals(1, h2Repo.findAll().size());
	}
	
	@Nested
	class TestWithPrecondition{
		private int id;
		
		private ObjectMapper mapper = new ObjectMapper();
		@BeforeEach
		public void setUp2(){
			User user = new User();
			user.setName("test");
			user.setEmail("test@hotmail");
			user.setPassword("testpass");
			User newUser = h2Repo.save(user);
			id = newUser.getUserId();
			System.out.println(newUser);
			List<User> users = h2Repo.findAll();
			for(User thisuser: users) {
				System.out.println(thisuser.toString());
			}
		}
		@AfterEach
		public void clean2() {
			h2Repo.deleteAll();
		}
		@Test
		public void testGetUser() {
			JsonNode reponse = (JsonNode) restTemplate.getForObject(baseUrl, JsonNode.class);
			System.out.println("response is " + reponse);
			List<UserResponseDto> users = mapper.convertValue(reponse, new TypeReference<List<UserResponseDto>>() {
			});
			System.out.println("response is " + users);
			assertEquals(1, users.size());
			assertEquals("test", users.get(0).getName());
		}
	}
	
	

}

package com.demo.dtos;

public class UserResponseDto {

	private int userId;
	private String name;
	private String email;
	private String password;
	private long timestamp;
	public UserResponseDto() {
		super();
	}
	public UserResponseDto(int userId, String name, String email, String password, long timestamp) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.timestamp = timestamp;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}

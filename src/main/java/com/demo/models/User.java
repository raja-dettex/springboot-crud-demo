package com.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "users")
public class User {
	
	@Id
	@GeneratedValue()
	private int userId;
	
	@Column()
	private String name;
	
	@Column()
	private String email;
	
	@Column()
	private String password;
	
	private long timestampAdded;
	public User() {

	}
	public User(int userId, String name, String email, String password, long timestampAdded) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.timestampAdded = timestampAdded;
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
	public long getTimestampAdded() {
		return timestampAdded;
	}
	public void setTimestampAdded(long timestampAdded) {
		this.timestampAdded = timestampAdded;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", timestampAdded=" + timestampAdded + "]";
	}
	
	
	
	
	
	
	
}

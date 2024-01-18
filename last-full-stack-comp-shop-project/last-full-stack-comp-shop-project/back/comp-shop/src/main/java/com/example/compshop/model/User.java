package com.example.compshop.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.IOException;

@Entity
@Data
@AllArgsConstructor
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String password;

	private String phone;

	private String name;

	public User() {

	}


	public User(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("json: " + jsonString);
			User user = mapper.readValue(jsonString, User.class);
			this.username = user.getUsername();
			this.password = user.getPassword();
			this.phone = user.getPhone();
			this.name = user.getName();
		} catch (IOException e) {
			System.out.println("Exception");
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

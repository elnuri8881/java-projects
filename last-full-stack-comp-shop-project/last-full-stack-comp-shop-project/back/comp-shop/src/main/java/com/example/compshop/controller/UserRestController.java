package com.example.compshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.compshop.model.AuthorityModel;
import com.example.compshop.model.User;
import com.example.compshop.repositery.AuthorityRepository;
import com.example.compshop.repositery.UserRepository;

@RestController
public class UserRestController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;
	@CrossOrigin
	@PostMapping( "/users")
	public User addUser(@RequestBody User user) {
		Optional<User> userOptional = userRepository.findById(user.getId());
		if(userOptional.isPresent()) {
			User u = new User();
			u.setName("");
			return u;
		}else {
		user.setPassword("{noop}"+user.getPassword());

		User savedUser = userRepository.save(user);

		AuthorityModel authority = new AuthorityModel();
		authority.setUsername(user.getUsername());
		authority.setAuthority("seller");
		authorityRepository.save(authority);

		return savedUser;
		}
	}
	@CrossOrigin()
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		User user1 = userRepository.findUserByUsernameAndPassword(user.getUsername(),"{noop}"+user.getPassword());
		System.out.println(user1);

		return user1;
	}
}

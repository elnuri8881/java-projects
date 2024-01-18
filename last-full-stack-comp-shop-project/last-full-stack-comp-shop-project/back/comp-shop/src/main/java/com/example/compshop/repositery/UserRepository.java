package com.example.compshop.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.compshop.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	public User findUserByUsernameAndPassword(String username,String password);
}

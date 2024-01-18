package com.example.compshop.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.compshop.model.AuthorityModel;



public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer> {

}

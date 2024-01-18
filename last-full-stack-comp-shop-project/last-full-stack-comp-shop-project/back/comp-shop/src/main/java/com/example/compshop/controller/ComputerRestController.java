package com.example.compshop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.manager.DummyProxySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.compshop.exception.MyRunTimeException;
import com.example.compshop.model.ComputerModel;
import com.example.compshop.repositery.ComputerRepository;
import com.example.compshop.repositery.UserRepository;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/computers")
public class ComputerRestController {

	@Autowired
	private ComputerRepository computerRepository;
	
	@Autowired
	private UserRepository userRepository;
	 
	
	@PostMapping
	public ComputerModel save( @RequestBody ComputerModel computer,BindingResult result) {
		System.out.println("salam6" + computer);
		if(result.hasErrors()){
			throw new MyRunTimeException(result);
		}
		
		return computerRepository.save(computer);
	}
 

	@GetMapping(path = "/{id}")
	public ComputerModel findById(@PathVariable Integer id) {
		return computerRepository.findById(id).get();
	}
	
	
	 
	@GetMapping(path = "/all")
	public List<ComputerModel> findAll(){
		return computerRepository.findAll();
	}
	
//	@GetMapping(path = "/all-seller")
//	public List<ComputerModel> findAllBySeller(){
//		return computerRepository.findAllBySeller(getUser());
//	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		computerRepository.deleteById(id);
	}
	
	
	
//	private String getUser() {
//		return SecurityContextHolder.getContext().getAuthentication().getName();
//	}
}

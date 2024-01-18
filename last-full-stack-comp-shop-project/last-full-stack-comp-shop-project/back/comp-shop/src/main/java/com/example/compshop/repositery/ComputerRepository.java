package com.example.compshop.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.compshop.model.ComputerModel;


public interface ComputerRepository extends JpaRepository<ComputerModel, Integer>{

//	public ComputerModel findById(Integer id);
//	@Query("Select *from users where id=?")
//	public List<ComputerModel> findAllByUserId(Integer userId);
	

}

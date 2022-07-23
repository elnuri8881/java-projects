package az.developia.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.studentcrud.model.AuthorityModel;

public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer>{

}

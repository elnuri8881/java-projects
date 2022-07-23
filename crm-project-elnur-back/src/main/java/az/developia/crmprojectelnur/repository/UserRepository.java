package az.developia.crmprojectelnur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.crmprojectelnur.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String>{

}

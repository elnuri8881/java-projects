package az.developia.crmprojectelnur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.crmprojectelnur.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

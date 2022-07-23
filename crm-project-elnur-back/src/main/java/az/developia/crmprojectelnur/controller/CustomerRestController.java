package az.developia.crmprojectelnur.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import az.developia.crmprojectelnur.exception.MyRunTimeException;
import az.developia.crmprojectelnur.model.Customer;
import az.developia.crmprojectelnur.model.CustomerDTO;
import az.developia.crmprojectelnur.model.Ticket;
import az.developia.crmprojectelnur.repository.CustomerRepository;
import az.developia.crmprojectelnur.repository.TicketRepository;

@RestController
@RequestMapping(path = "/customers")
@CrossOrigin(origins = "*")
@PreAuthorize(value = "hasAnyAuthority('admin','user')")
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TicketRepository ticketRepository;

	
	@PostMapping
	//@PreAuthorize(value = "hasAnyAuthority('admin','user')")
	public Customer save(@Valid @RequestBody Customer customer, BindingResult result) {
		if(result.hasErrors()) {
			throw new MyRunTimeException(result);
		}
		return customerRepository.save(customer);
		
	}
	
	@GetMapping
	//@PreAuthorize(value = "hasAnyAuthority('admin','user')")
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	@DeleteMapping(path = "/{id}")
	//@PreAuthorize(value = "hasAnyAuthority('admin','user')")
	public void deleteById(@PathVariable Integer id) {
		customerRepository.deleteById(id);
	}

	@GetMapping(path = "/{id}")
	public Customer findById(@PathVariable Integer id) {
		Optional<Customer> cr = customerRepository.findById(id);
		if(cr.isPresent()) {
			return cr.get();
		}else {
			throw new RuntimeException("Id not found !");
		}
		
	}
	
	
	@GetMapping(path = "/withtickets/{id}")
	public CustomerDTO findByIdWithTickets(@PathVariable Integer id) {
		Optional<Customer> cr1 = customerRepository.findById(id);
		if(cr1.isPresent()) {
			CustomerDTO custDto = new CustomerDTO();
			custDto.setId(cr1.get().getId());
			custDto.setName(cr1.get().getName());
			List<Ticket> tickets = ticketRepository.findAllByCustomerId(cr1.get().getId());
			custDto.setTickets(tickets);
			return custDto;
			
		}else {
			throw new RuntimeException("Id not found !");
		}
	}
	
	
	
	

	
}

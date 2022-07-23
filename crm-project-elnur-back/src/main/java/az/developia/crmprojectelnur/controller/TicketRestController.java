package az.developia.crmprojectelnur.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.crmprojectelnur.model.Ticket;
import az.developia.crmprojectelnur.repository.TicketRepository;

@RestController
@RequestMapping(path = "/tickets")
@CrossOrigin(origins = "*")
@PreAuthorize(value = "hasAnyAuthority('manager','user')")
public class TicketRestController {

	@Autowired
	private TicketRepository ticketRepository;

	@PostMapping
	public Ticket save(@Valid @RequestBody Ticket t, BindingResult br) {
		if (br.hasErrors()) {
			throw new RuntimeException();
		}
		return ticketRepository.save(t);

	}

	@GetMapping(path = "/{id}")
	public Ticket findById(@PathVariable Integer id) {
		Optional<Ticket> c = ticketRepository.findById(id);
		if (c.isPresent()) {
			return c.get();
		} else {
			throw new RuntimeException("Id not found !");
		}

	}

}

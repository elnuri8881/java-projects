package az.developia.crmprojectelnur.controller;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.crmprojectelnur.model.Nationality;
import az.developia.crmprojectelnur.repository.NationalityRepository;

@RestController
@RequestMapping(path = "/nationalities")
@CrossOrigin(origins = "*")
public class NationalityRestController {

	@Autowired
	public NationalityRepository nationalityRepository;
	
	@PostMapping
	public Nationality save(@Valid @RequestBody Nationality n, BindingResult br) {
		if(br.hasErrors()) {
			throw new RuntimeException("");
		}
		return nationalityRepository.save(n);
	}
	
}

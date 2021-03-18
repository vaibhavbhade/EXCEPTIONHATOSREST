package com.atyeti.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atyeti.rest.exception.UserNotFoundException;
import com.atyeti.rest.model.CarOne;
import com.atyeti.rest.model.User;
import com.atyeti.rest.model.UserRepo;
import com.atyeti.rest.servcice.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class UserController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserService userservice;

	@GetMapping("/user")
	public List<User> getAllUser() {
		return userservice.getUserData();

	}

	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable int id) {
		User user = userservice.getUser(id);
		if (user == null) { throw new UserNotFoundException("id-" + id); }
		
		return user;

	}

	@PostMapping("/saveUser")
	public EntityModel<User> getUser(@Valid @RequestBody User user) {
		System.out.println(user.getId());
		if (user.getId() == 0) {
			throw new UserNotFoundException(" user is null");
		}
		userservice.createUser(user);
		
		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUser());
		entityModel.add(linkTo.withRel("get all user"));
		return entityModel;

	}

	@GetMapping("/Hello")
	public String getMessage( Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	

	@GetMapping("/filter-demo")
	public MappingJacksonValue filterDempo(Principal principal) {
	//List<Car> list=Arrays.asList(new Car("vaibhav",1),new Car("vv",2));
	
		CarOne car=new CarOne(1,"vaibhav");
	SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name");
	
	FilterProvider filters=new SimpleFilterProvider().addFilter("filterProperty", filter);
	
	MappingJacksonValue mapping=new MappingJacksonValue(car);
	mapping.setFilters(filters);
	
	return mapping;
	
	
		
	}
	
	
	@Autowired
	private UserRepo userRepo;
	
	
	@GetMapping("/getCarUser")
	public void getCarUser( @RequestBody User user) {
		
		
	System.out.println(user.getName());
	
	//return user.getListOfCar();
	}
	
	

}

package com.atyeti.rest.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("filterProperty")
@Component
public class CarOne {
	private Integer id;

	
	private String name;

	public CarOne() {}
	

	public CarOne(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}

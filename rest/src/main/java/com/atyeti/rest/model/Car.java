package com.atyeti.rest.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*@JsonFilter("filterProperty")
*/
@Entity
public class Car {
	
	@Id
	@GeneratedValue
private Integer id;

	
private String name;	
	
private int no;
@JsonIgnore

@ManyToOne(fetch = FetchType.LAZY)
private User user;

public Car() {
	
}

public Car(String name, int no) {
	super();
	this.name = name;
	this.no = no;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}



}

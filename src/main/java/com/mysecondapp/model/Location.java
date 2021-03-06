package com.mysecondapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Location {

	@Id
	private Integer id;

	private String name;

	@OneToMany(mappedBy="location" , cascade = CascadeType.ALL)   ////used to tell mapping is already done
	private List<User> users;

	public Location(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@JsonManagedReference
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
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

	public Location() {
		super();
	}

}

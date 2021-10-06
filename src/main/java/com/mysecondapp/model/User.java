package com.mysecondapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {

	@Id
	private Integer id;
	
	@JsonManagedReference                       ///used to avoid recursion problem
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	private String firstName;
	
	private String lastName;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;

	@ManyToOne
	@JoinColumn(name="locationid", insertable = false, updatable=false)
	private Location location;
	
	private String email;

	public User() {
		super();
	}
	private Integer locationid;

	public Integer getLocationid() {
	    return locationid;
	}

	public void setLocationid(Integer locationid) {
	    this.locationid = locationid;
	}
	public User(Integer id, String firstName, String lastName, Location location, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonBackReference
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

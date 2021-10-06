package com.mysecondapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysecondapp.model.Post;
import com.mysecondapp.model.User;
import com.mysecondapp.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/users/{id}/posts")  //takes the user_id and returns the posts for that user.
	public List<Post> getPostsById(@PathVariable Integer id) {
		Optional<User> user = userService.getUserById(id);
		if(user.isPresent())
			return user.get().getPosts();
		return null;
	}
	
	@GetMapping("/users/{id}/locations")  //takes the user_id and returns the posts for that user.
	public List<User> getUsersById(@PathVariable Integer id) {
		return userService.getUserByLocaion(id);
		
	}
	
	@PostMapping("/users/addNewUser")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
}

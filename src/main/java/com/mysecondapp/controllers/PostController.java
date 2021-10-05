package com.mysecondapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mysecondapp.model.Post;
import com.mysecondapp.services.PostServices;

@RestController
public class PostController {

	@Autowired
	private PostServices postService;

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return postService.findAll();
	}

	@GetMapping("/posts/{id}")
	public Optional<Post> getPostById(@PathVariable Integer id) {
		return postService.findById(id);
	}
	
	@GetMapping("/posts/user/{id}/posts")
	public List<Post> getPostsByUser(@PathVariable Integer id) {
	    return postService.findByLocationId(id);
	}

}

package com.mysecondapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/post/addNewPost")
	public void addNewPost(@RequestBody Post post) {
		postService.addPosts(post);
	}

	@PutMapping("/updatePost")
	public void updatePost(@RequestBody Post post) {
		postService.updatePosts(post);
	}
	
	@DeleteMapping("/deletePost/{id}")
	public void deletePost(@PathVariable Integer id) {
		postService.deletePost(id);
	}
}

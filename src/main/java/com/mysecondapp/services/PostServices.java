package com.mysecondapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysecondapp.model.Post;
import com.mysecondapp.repositories.PostRepository;

@Service
public class PostServices {

	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {
		return (List<Post>) postRepository.findAll();
	}

	public Optional<Post> findById(Integer id) {
		return postRepository.findById(id);
	}

	public List<Post> findByLocationId(Integer id) {
	    return postRepository.findByUserId(id);
	}
	
	public void addPosts(Post post) {
		postRepository.save(post);
	}
	
	public void updatePosts(Post post) {
		postRepository.save(post);
	}
}

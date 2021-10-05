package com.mysecondapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysecondapp.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	List<Post> findByUserId(Integer id);
}

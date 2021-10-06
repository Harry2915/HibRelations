package com.mysecondapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysecondapp.model.User;
import com.mysecondapp.repositories.UserRepository;

@Service
public class UserServices {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	public List<User> getUserByLocaion(Integer id){
		return userRepository.findByLocationId(id);
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteuser(Integer id) {
		userRepository.deleteById(id);
	}
}

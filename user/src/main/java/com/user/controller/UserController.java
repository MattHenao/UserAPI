package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping()
	public User userSave(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping("/{id}")
	public User findByIdUser(@PathVariable Integer id) {
		return userService.findById(id);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Integer id) {
		User actualUser = userService.findById(id);
		
		actualUser.setUsername(user.getUsername());
		actualUser.setEmail(user.getEmail());
		actualUser.setPassword(user.getPassword());

		return userService.update(actualUser);
	}
	
	@GetMapping
	public List<User> getUser(){
		return userService.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.delete(id);
	}
}

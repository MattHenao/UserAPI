package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {
	public User save(User user);
	public List<User> findAll();
	public void delete(Integer id);
	public User findById(Integer id);
	public User update(User user);
}

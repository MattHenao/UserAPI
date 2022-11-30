package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.dao.UserDao;
import com.user.exception.UserBadRequestException;
import com.user.exception.UserNotFoundException;
import com.user.model.User;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = false)
	public User save(User user) {
		if(user.getUsername() == null || user.getEmail() == null || user.getPassword() == null) {
			throw new UserBadRequestException("Mandatory parameters not entered");
		}
		return userDao.save(user);
	}
	
	@Override
	@Transactional(readOnly = false)
	public User update(User user) {
		return userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		if(((List<User>) userDao.findAll()).isEmpty())
			throw new UserNotFoundException("There is no users created");
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id) {
		if(userDao.findById(id).isEmpty()) {
			throw new UserNotFoundException("Requested user does not exist");
		}
		userDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Integer id) {
		if(userDao.findById(id).isEmpty()) {
			throw new UserNotFoundException("Requested user does not exist");
		}
		return userDao.findById(id).orElse(null);
	}
}

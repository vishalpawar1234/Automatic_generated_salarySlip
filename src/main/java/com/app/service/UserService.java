package com.app.service;

import java.util.List;

import com.app.entities.User;

public interface UserService {

	// Method to get list of all users
	List<User> getAllUsers();
	
	// Method to get user by it's id  
	User getUserById(Long id);
	
	// Method to update user
    User updateUser(User user);
    
    // Method to delete user
	void deleteUserById(Long id);
	
	User saveEmployee(User user);
	
	

}

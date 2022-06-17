package com.Login.demoUserLogin.details;

import java.util.List;

import com.Login.demoUserLogin.entities.User;



public interface UserDetails {
	
	

	public List<User> getUsers();

	public User getUser(long id);

	public User addUser(User user);

	public User updateUser(User user);

	public void deleteUser(long id);
	
	 
	

	

}

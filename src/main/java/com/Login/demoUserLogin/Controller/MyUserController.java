package com.Login.demoUserLogin.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Login.demoUserLogin.details.UserDetails;
import com.Login.demoUserLogin.entities.User;



@RestController
public class MyUserController {
	
	@Autowired
	private UserDetails udetails;
	
 public String home()
 {
	 return "Welcome to user application";
 }

 
 //get the all Users
 @GetMapping("/users")
 public List <User>getUsers() 
 {
	return this.udetails.getUsers();
 }

 //get by id
 @GetMapping("/users/{id}")
 public User getUser(@PathVariable long id) 
 {
	return this.udetails.getUser(id);
 }
 
 @PostMapping("/users")
 public User addUser(@RequestBody User user)
 {
	 return this.udetails.addUser(user);
 }

 //update user using Put request
 @PutMapping("/users")
 public User updateUser(@RequestBody User user)
 {
	 return this.udetails.updateUser(user);
 }
 
 //delete user
 @DeleteMapping("/users/{id}")
 public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id)
 {
	 try {
		 
		 this.udetails.deleteUser(id);
		 return new ResponseEntity<>(HttpStatus.OK);
		 
	 }
	 catch (Exception e) {
		// TODO: handle exception
		 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
 }
 
 
}

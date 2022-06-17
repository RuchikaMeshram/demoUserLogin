package com.Login.demoUserLogin.details;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Login.demoUserLogin.entities.User;

@Service
public class UserDetailsImpln implements UserDetails {
	
	List <User> list;
	
	public UserDetailsImpln()
	{
		list = new ArrayList<>();
		list.add(new User (123, "Ram" ,"ram123"));
		list.add(new User (113, "sham" ,"s123"));
		list.add(new User (723, "kiran" ,"kir"));
	}
	
	public List<User>getUsers()
	{
		return list;
	}

	@Override
	public User getUser(long id) {
		
		User u=null;
		for(User us : list)
		{
			if(us.getId()==id)
			{
				u=us;
				break;
			}
		}
		return u;
	}

	@Override
	public User addUser(User user) {

		list.add(user);
		return user;
	}

	@Override
	public User updateUser(User user) {

		list.forEach(e -> {
			if(e.getId() == user.getId())
			{
				e.setName(user.getName());
				e.setPassword(user.getPassword());
			}
		});
		
		return user;
	}

	@Override
	public void deleteUser(long id) {

		list=this.list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
		
	}

}

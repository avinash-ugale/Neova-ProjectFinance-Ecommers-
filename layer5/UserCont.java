package com.example.demo.layer5;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.User;

import com.example.demo.layer3.UserRepoImpl;

@RestController
@RequestMapping("/user")
public class UserCont {

	@Autowired
	UserRepoImpl userRepo;
	
	@RequestMapping("/getuser/{uno}")//localhost:8080/user/getuser
	public User getUser(@PathVariable("uno") int uno)
	{
		User user = null;
		user=userRepo.selectUser(uno);
		
		System.out.println("controller : emi : "+user.getUserId());
		return user;
	}
	@RequestMapping("/getAll")//localhost:8080/user/getAll
	public List<User> getuser()
	{
		System.out.println("getAll");
		List<User> userList;
		userList=userRepo.selectUsers();
		return userList;
	}
	
		@PostMapping("/Add")
		public void addUser(@RequestBody User user)
		{
		userRepo.insertUser(user);
		}
	
		@PutMapping("/update")//http://localhost:8080/user/update
		public void updateUser(@RequestBody User user)
		{
		userRepo.updateUser(user);
		}
	
		@DeleteMapping("/delete/{uno}")//http://localhost:8080/user/delete/45
		public String deleteUser(@PathVariable("uno") int uno)
		{
		userRepo.deleteUser(uno);
		return "delete successfully";
		}

	}


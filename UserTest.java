package com.example.demo;

import com.example.demo.layer2.User;
import com.example.demo.layer3.UserRepoImpl;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.swing.Spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
	@Autowired
	UserRepoImpl userRepo;
	
	@Test
	void insertUser() {
            User user=new User();
            
            user.setAccountNumber(25367722);
            user.setAccountStatus("Saving");
            user.setAddress("pune");
            user.setBankName("SBI");
            user.setCibilScore(283837);
            user.setDateOfBirth(LocalDate.of(1998, 02, 01));
            user.setEmail("avinashugale35@gmail.com");
            user.setIfsc("UBIN255");
            user.setPanCard("AGHH2");
            user.setPassword("AVINAHS");
            user.setPhoneNumber(293092882);
           
            user.setUserName("Lokesh");
           
        	userRepo.insertUser(user);
	}
	
	@Test
	void selectUserTest()
	{
		User user;
		user=userRepo.selectUser(39);
		System.out.println("User  :"+user.getUserId());
		System.out.println("User  :"+user.getAccountNumber());
		System.out.println("User  :"+user.getEmail());
		System.out.println("User  :"+user.getIfsc());
		System.out.println("User  :"+user.getPanCard());
		System.out.println("User  :"+user.getPassword());
		System.out.println("User  :"+user.getPhoneNumber());
		System.out.println("User  :"+user.getDateOfBirth());
		System.out.println("User  :"+user.getCibilScore());
		System.out.println("User  :"+user.getBankName());
		System.out.println("User  :"+user.getAccountStatus());
		System.out.println("User  :"+user.getAddress());
		System.out.println("User  :"+user.getUserName());
	}
	
	
	@Test
	void selectAllUserTest()
	{
		List<User> userList;
		userList=userRepo.selectUsers();
		for(User user :userList)
		{
			System.out.println("User  :"+user.getUserId());
			System.out.println("User  :"+user.getAccountNumber());
			System.out.println("User  :"+user.getEmail());
			System.out.println("User  :"+user.getIfsc());
			System.out.println("User  :"+user.getPanCard());
			System.out.println("User  :"+user.getPassword());
			System.out.println("User  :"+user.getPhoneNumber());
			System.out.println("User  :"+user.getDateOfBirth());
			System.out.println("User  :"+user.getCibilScore());
			System.out.println("User  :"+user.getBankName());
			System.out.println("User  :"+user.getAccountStatus());
			System.out.println("User  :"+user.getAddress());
			System.out.println("User  :"+user.getUserName());
			
		}
	}
		
		
		@Test
		void updateApplicationTest()
		{
            User user = null;
            user =userRepo.find(User.class, 39);
	    	Assertions.assertNotNull(user);
	   	
	    user.setAccountNumber(25367722);
        user.setAccountStatus("Current");
        user.setAddress("pune");
        user.setBankName("SBI");
        user.setCibilScore(283837);
        user.setDateOfBirth(LocalDate.of(1998, 02, 01));
        user.setEmail("avinashugale35@gmail.com");
        user.setIfsc("UBIN255");
        user.setPanCard("AGHH2");
        user.setPassword("Om");
        user.setPhoneNumber(293092882);
       
        user.setUserName("Sagar");
		



		userRepo.updateUser(user);
		}	
		
		@Test
		void deleteUserTest()
		{
			User delete=null;
			
		   delete=userRepo.find(User.class,39);
			
		  userRepo.deleteUser(39);
		}
		
	}



package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.EMI;
import com.example.demo.layer2.User;

import com.example.demo.layer3.EMIRepoImpl;
import com.example.demo.layer3.UserRepoImpl;

@SpringBootTest
public class OneToOneTestUserToEmi {
	@Autowired
	UserRepoImpl u;
	@Autowired
	EMIRepoImpl c;
	
	@Test
	void OneToOneTestUserToEmi() {

		User user = u.selectUser(32);
		EMI card1 = c.selectEMI(48);

		user.setEmi(card1);
		card1.setUser(user);
		u.merge(card1);
		c.merge(user);
	}

}

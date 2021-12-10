package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.EMICard;
import com.example.demo.layer2.User;
import com.example.demo.layer3.EMICardRepoImpl;
import com.example.demo.layer3.UserRepoImpl;

@SpringBootTest
public class OneToOneTest {
	@Autowired
	UserRepoImpl u;
	@Autowired
	EMICardRepoImpl c;
	
	@Test
	void oneToOneTest() {

		User user = u.selectUser(32);
		EMICard card1 = c.selectEmiCard(35);

		user.setEmiCard(card1);
		card1.setUser(user);
		u.merge(card1);
		c.merge(user);
	}

}

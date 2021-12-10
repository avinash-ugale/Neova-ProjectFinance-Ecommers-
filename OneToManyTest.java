package com.example.demo;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.Orders;
import com.example.demo.layer2.User;
import com.example.demo.layer3.OrdersRepoImpl;
import com.example.demo.layer3.UserRepoImpl;


@SpringBootTest
public class OneToManyTest {
	@Autowired
	UserRepoImpl u;
	@Autowired
	OrdersRepoImpl o;
	
	@Test
	void oneToManyTest() {
		
		User user1=u.selectUser(21);
		Set<Orders> ol1=user1.getUserOrderSet();
		Orders order1=o.selectOrder(49);
		Orders order2=o.selectOrder(32);
		
		order1.setUserOrderId(user1);
		order2.setUserOrderId(user1);
		ol1.add(order1);
		ol1.add(order2);
		u.updateUser(user1);
		o.updateOrders(order1);
		o.updateOrders(order2);
	}


	

}

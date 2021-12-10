package com.example.demo;


import com.example.demo.layer2.Orders;
import com.example.demo.layer2.User;
import com.example.demo.layer3.OrdersRepoImpl;
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
public class OrderTest {
         
	@Autowired
	OrdersRepoImpl ordersRepo;
	
	@Test
	void insertOrders() {
            Orders orders=new Orders();
          
            orders.setEmiScheme("OFF");
            orders.setOrderDate(LocalDate.of(1998, 02, 01));
          
          
           
        	ordersRepo.insertOrder(orders);
	}
	
	@Test
	void selectOrdersTest()
	{
		Orders orders;
		orders=ordersRepo.selectOrder (45);
		System.out.println("Product  :"+orders.getEmiScheme());
		System.out.println("Product  :"+orders.getOrderDate());
		
	}
	
	
	@Test
	void selectAllOrderTest()
	{
		List<Orders> ordersList;
		ordersList=ordersRepo.selectOrders ();
		for(Orders orders :ordersList)
		{
			System.out.println("orders  :"+orders.getEmiScheme());
			System.out.println("orders  :"+orders.getOrderDate());
			
		
			
		}
	}
		
		
		@Test
		void updateOrdersTest()
		{
            Orders orders = null;
            orders =ordersRepo.find(Orders.class, 45);
	    	Assertions.assertNotNull(orders);
	   	
	    	    orders.setEmiScheme(" discount");
	            orders.setOrderDate(LocalDate.of(1999, 03, 01));
	          
	          
	           
	        	ordersRepo.updateOrders(orders);
		}


			
		
		@Test
		void deleteOrdersTest()
		{
			Orders delete=null;
			
		   delete=ordersRepo.find(Orders.class,45);
			
		  ordersRepo.deleteOrders(45);
		}
		
	}


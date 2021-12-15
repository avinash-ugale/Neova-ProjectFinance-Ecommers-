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

import com.example.demo.layer2.Orders;
import com.example.demo.layer3.OrdersRepoImpl;



@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrdersRepoImpl ordersRepo;
	
	@RequestMapping("/getorder/{ordersno}")//localhost:8080/user/getuser
	public Orders getOrder(@PathVariable("uno") int ordersno)
	{
		Orders orders = null;
		orders=ordersRepo.selectOrder(ordersno);
		
		System.out.println("controller : emi : "+orders.getOrderId());
		return orders;
	}
	@RequestMapping("/getAll")//localhost:8080/user/getAll
	public List<Orders> getorders()
	{
		System.out.println("getAll");
		List<Orders> ordersList;
		ordersList=ordersRepo.selectOrders();
		return ordersList;
	}
	
		@PostMapping("/Add")
		public void addOrders(@RequestBody Orders orders)
		{
		ordersRepo.insertOrder(orders);
		}
	
		@PutMapping("/update")//http://localhost:8080/user/update
		public void updateUser(@RequestBody Orders orders)
		{
		ordersRepo.updateOrders(orders);
		}
	
		@DeleteMapping("/delete/{ordersno}")//http://localhost:8080/user/delete/45
		public String deleteUser(@PathVariable("ordersno") int ordersno)
		{
		ordersRepo.deleteOrders(ordersno);
		return "delete successfully";
		}

	}


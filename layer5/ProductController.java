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
import com.example.demo.layer2.Product;
import com.example.demo.layer3.OrdersRepoImpl;
import com.example.demo.layer3.ProductRepoImpl;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepoImpl productRepo;
	
	@RequestMapping("/getorder/{productNo}")//localhost:8080/user/getuser
	public Product getProduct(@PathVariable("productNo") int productNo)
	{
		Product product = null;
		product=productRepo.selectProduct(productNo);
		
		System.out.println("controller : emi : "+product.getProductId());
		return product;
	}
	@RequestMapping("/getAll")//localhost:8080/user/getAll
	public List<Product> getproduct()
	{
		System.out.println("getAll");
		List<Product> productList;
		productList=productRepo.selectProduct();
		return productList;
	}
	
		@PostMapping("/Add")
		public void addProduct(@RequestBody Product product)
		{
		productRepo.insertProduct(product);
		}
	
		@PutMapping("/update")//http://localhost:8080/user/update
		public void updateProduct(@RequestBody Product product)
		{
		productRepo.updateProduct(product);
		}
	
		@DeleteMapping("/delete/{productNo}")//http://localhost:8080/user/delete/45
		public String deleteUser(@PathVariable("productNo") int productNo)
		{
		productRepo.deletePerson(productNo);
		return "delete successfully";
		}

	}


package com.example.demo;


import com.example.demo.layer2.Product;
import com.example.demo.layer2.User;
import com.example.demo.layer3.ProductRepoImpl;
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
public class ProductTest {
         
	@Autowired
	ProductRepoImpl productRepo;
	
	@Test
	void insertProduct() {
            Product product=new Product();
            product.setProductCost(30000);
            product.setProductDetails("Good Quality");
            product.setProductName("Tv");
            
          
           
        	productRepo.insertProduct(product);
	}
	
	@Test
	void selectProductTest()
	{
		Product product;
		product=productRepo.selectProduct(43);
		System.out.println("Product  :"+product.getProductId());
		System.out.println("Product  :"+product.getProductCost());
		System.out.println("Product  :"+product.getProductDetails());
		System.out.println("Product  :"+product.getProductName());
	
	}
	
	
	@Test
	void selectAllProductTest()
	{
		List<Product> productList;
		productList=productRepo.selectProduct ();
		for(Product product :productList)
		{
			System.out.println("Product  :"+product.getProductId());
			System.out.println("Product  :"+product.getProductCost());
			System.out.println("Product  :"+product.getProductDetails());
			System.out.println("Product  :"+product.getProductName());
		
			
		}
	}
		
		
		@Test
		void updateProductTest()
		{
            Product product = null;
            product =productRepo.find(Product.class, 43);
	    	Assertions.assertNotNull(product);
	   	
	        product.setProductCost(20000);
	        product.setProductDetails("BAd");
	        product.setProductName("AC");
		
	        productRepo.updateProduct(product);
		}


			
		
		@Test
		void deleteProductTest()
		{
			Product delete=null;
			
		   delete=productRepo.find(Product.class,43);
			
		  productRepo.deleteProduct(43);
		}
		
	}


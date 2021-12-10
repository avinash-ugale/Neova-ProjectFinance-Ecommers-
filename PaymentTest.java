package com.example.demo;



import com.example.demo.layer2.PaymentAndInstallment;
import com.example.demo.layer2.Product;
import com.example.demo.layer2.User;
import com.example.demo.layer3.PaymentAndInstallmentRepo;
import com.example.demo.layer3.PaymentAndInstallmentRepoImpl;
import com.example.demo.layer3.ProductRepoImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.swing.Spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentTest {
	
	@Autowired
	PaymentAndInstallmentRepoImpl paymentRepo;
	
	@Test
	void insertPayment() {
            PaymentAndInstallment payment=new PaymentAndInstallment();
            
            payment.setAmountPaid(245.34f);
            payment.setCountOfInstallment(240);
            payment.setDateOFPayment(LocalDate.of(2021, 12, 01));
            payment.setPaidStatus(23.2f);
       
            
            
          
           
        	paymentRepo.insertInstallment (payment);
	}
	
	@Test
	void selectPaymentAndInstallmentTest()
	{
		PaymentAndInstallment payment;
		payment=paymentRepo.selectInstallment(44);
		System.out.println("PaymentAndInstallment  :"+payment.getAmountPaid());
		System.out.println("PaymentAndInstallment  :"+payment.getCountOfInstallment());
		System.out.println("PaymentAndInstallment  :"+payment.getDateOFPayment());
		System.out.println("PaymentAndInstallment  :"+payment.getPaidStatus());
	
	}
	
	
	@Test
	void selectAllPaymentTest()
	{
		List<PaymentAndInstallment>PaymentAndInstallmentList;
		PaymentAndInstallmentList=paymentRepo.selectInstallment ();
		for(PaymentAndInstallment payment :PaymentAndInstallmentList)
		{
			System.out.println("PaymentAndInstallment :"+payment.getPaidStatus());
			System.out.println("PaymentAndInstallment  :"+payment.getAmountPaid());
			System.out.println("PaymentAndInstallment  :"+payment.getCountOfInstallment());
			System.out.println("PaymentAndInstallment  :"+payment.getDateOFPayment());
		
			
		}
	}
		
		
		@Test
		void updatePaymentTest()
		{
			PaymentAndInstallment payment = null;
            payment =paymentRepo.find(PaymentAndInstallment.class,44);
	    	Assertions.assertNotNull(payment);
	   	
	        payment.setAmountPaid(0);
	        payment.setCountOfInstallment(0);
	        payment.setDateOFPayment(LocalDate.of(2021, 12, 02));
	        payment.setPaidStatus(0);
		
	        paymentRepo.updateInstallment(payment);
		}


			
		
		@Test
		void deletePaymentTest()
		{
			PaymentAndInstallment delete=null;
			
		   delete=paymentRepo.find(PaymentAndInstallment.class,43);
			
		  paymentRepo.deleteInstallment(43);
		}
		
	}



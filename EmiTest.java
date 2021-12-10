package com.example.demo;


import com.example.demo.layer2.EMI;
import com.example.demo.layer2.User;
import com.example.demo.layer3.EMIRepoImpl;
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
public class EmiTest {
         
	@Autowired
	EMIRepoImpl emiTestRepo;
	
	@Test
	void insertEmiTest() {
		EMI emiTest=new EMI();
		emiTest.setExpirationDate(LocalDate.of(2022, 2, 1));
		emiTest.setRemainingBalance(234.5f);
          
        
          
          
           
           emiTestRepo.insertEMI(emiTest);
	}
	
	@Test
	void selectEMICardTest()
	{
		EMI emiTest;
		emiTest=emiTestRepo.selectEMI(47);
		System.out.println("EMICARD  :"+emiTest.getExpirationDate());
		System.out.println("EMICARD  :"+emiTest.getRemainingBalance());
	
		
	}
	
	


	@Test
	void selectAllEMICardTest()
	{
		List<EMI> emiTestList;
		emiTestList=emiTestRepo.selectEMIs ();
		for(EMI emiTest :emiTestList)
		{
			System.out.println("EMICARD  :"+emiTest.getExpirationDate());
			System.out.println("EMICARD  :"+emiTest.getRemainingBalance());
			
		
			
		}
	}
		
		
		@Test
		void updateEmiCardTest()
		{
			EMI emiTest = null;
            emiTest =emiTestRepo.find(EMI.class, 47);
	    	Assertions.assertNotNull(emiTest);
	   	
	    	emiTest.setExpirationDate(LocalDate.of(2023, 2, 1));
			emiTest.setRemainingBalance(134.5f);
	          
	          
	           
	           emiTestRepo.updateEMI(emiTest);
		}


			
		
		@Test
		void deleteEMICardTest()
		{
			EMI delete=null;
			
		   delete=emiTestRepo.find(EMI.class,47);
			
		   emiTestRepo.deleteEMI(47);
		}
		
	}


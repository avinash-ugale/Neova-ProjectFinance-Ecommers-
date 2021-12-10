package com.example.demo;


import com.example.demo.layer2.EMICard;
import com.example.demo.layer2.User;
import com.example.demo.layer3.EMICardRepoImpl;
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
public class EMICardTest {
         
	@Autowired
	EMICardRepoImpl emiCardRepo;
	
	@Test
	void insertEMICard() {
            EMICard emiCard=new EMICard();
          
           emiCard.setCardLimit(200000);
           emiCard.setCardType("gold");
           emiCard.setCostOfCard(10000);
          
          
           
           emiCardRepo.insertEMICard(emiCard);
	}
	
	@Test
	void selectEMICardTest()
	{
		EMICard emiCard;
		emiCard=emiCardRepo.selectEmiCard (46);
		System.out.println("EMICARD  :"+emiCard.getCardLimit());
		System.out.println("EMICARD  :"+emiCard.getCardType());
		System.out.println("EMICARD  :"+emiCard.getCostOfCard());
		
	}
	
	
	@Test
	void selectAllEMICardTest()
	{
		List<EMICard> emiCardList;
		emiCardList=emiCardRepo.selectEmiCard ();
		for(EMICard emiCard :emiCardList)
		{
			System.out.println("EMICARD  :"+emiCard.getCardLimit());
			System.out.println("EMICARD  :"+emiCard.getCardType());
			System.out.println("EMICARD  :"+emiCard.getCostOfCard());
			
		
			
		}
	}
		
		
		@Test
		void updateEMICardTest()
		{
            EMICard emiCard = null;
            emiCard =emiCardRepo.find(EMICard.class, 46);
	    	Assertions.assertNotNull(emiCard);
	   	
	    	  
	    	   emiCard.setCardLimit(200000);
	           emiCard.setCardType("platinum");
	           emiCard.setCostOfCard(10000);
	          
	          
	           
	            emiCardRepo.updateEmiCard(emiCard);
		}


			
		
		@Test
		void deleteEMICardTest()
		{
			EMICard delete=null;
			
		   delete=emiCardRepo.find(EMICard.class,46);
			
		  emiCardRepo.deleteEmiCard(46);
		}
		
	}


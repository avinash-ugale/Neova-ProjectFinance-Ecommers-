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

import com.example.demo.layer2.EMICard;
import com.example.demo.layer3.EMICardRepoImpl;



@RestController
@RequestMapping("/emiCard")
public class EMICardController {

	@Autowired
	EMICardRepoImpl emiCardRepo;
	
	@RequestMapping("/getemiCard/{emiCardNumber}")//localhost:8080/user/getuser
	public EMICard getEMICard(@PathVariable("emiCardNumber") int emiCardNumber)
	{
		EMICard emiCard = null;
		emiCard=emiCardRepo.selectEmiCard(emiCardNumber);
		
		System.out.println("controller : emi : "+emiCard.getCardTypeNo());
		return emiCard;
	}
	@RequestMapping("/getAll")//localhost:8080/emiCard/getAll
	public List<EMICard> getemiCard()
	{
		System.out.println("getAll");
		List<EMICard> emiCardList;
		emiCardList=emiCardRepo.selectEmiCard();
		return emiCardList;
	}
	
		@PostMapping("/Add")
		public void addEMICard(@RequestBody EMICard emiCard)
		{
		emiCardRepo.insertEMICard(emiCard);
		}
	
		@PutMapping("/update")//http://localhost:8080/emiCard/update
		public void updateUser(@RequestBody EMICard emiCard)
		{
		emiCardRepo.updateEmiCard(emiCard);
		}
	
		@DeleteMapping("/delete/{emiCardNumber}")//http://localhost:8080/user/delete/45
		public String deleteEMICard(@PathVariable("emiCardNumber") int emiCardNumber)
		{
		emiCardRepo.deleteEmiCard(emiCardNumber);
		return "delete successfully";
		}

	}


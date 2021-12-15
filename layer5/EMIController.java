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

import com.example.demo.layer2.EMI;
import com.example.demo.layer3.EMIRepoImpl;



@RestController
@RequestMapping("/emi")
public class EMIController {

	@Autowired
	EMIRepoImpl emiRepo;
	
	@RequestMapping("/getEmi/{emino}")//localhost:8080/user/getuser
	public EMI getUser(@PathVariable("emiCardNumber") int emino)
	{
		EMI emi = null;
		emi=emiRepo.selectEMI(emino);
		
		System.out.println("controller : emi : "+emi.getEmiCardNo());
		return emi;
	}
	@RequestMapping("/getAll")//localhost:8080/emi/getAll
	public List<EMI> getEmi()
	{
		System.out.println("getAll");
		List<EMI> emiList;
		emiList=emiRepo.selectEMIs();
		return emiList;
	}
	
		@PostMapping("/Add")
		public void addEMI(@RequestBody EMI emi)
		{
		emiRepo.insertEMI(emi);
		}
	
		@PutMapping("/update")//http://localhost:8080/emi/update
		public void updateEMI(@RequestBody EMI emi)
		{
		emiRepo.updateEMI(emi);
		}
	
		@DeleteMapping("/delete/{emino}")//http://localhost:8080/emi/delete/45
		public String deleteUser(@PathVariable("emino") int emino)
		{
	      emiRepo.deleteEMI(emino);
		return "delete successfully";
		}

	}


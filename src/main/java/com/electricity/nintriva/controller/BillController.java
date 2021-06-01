package com.electricity.nintriva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.nintriva.model.BillInputDetails;
import com.electricity.nintriva.service.BillService;


@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired 
	BillService billService;
	
	@PostMapping(value="/submit")
	public void submitBill(@RequestBody BillInputDetails billInputDetails) { 
		
	  billService.submitBill(billInputDetails);
	}
	
	
	@GetMapping("/get/{consumerNumber}")
	public int getUserBill(@PathVariable String consumerNumber) { 
		
		int consumerNo = Integer.parseInt(consumerNumber);
		return consumerNo;
	}
	
	
}

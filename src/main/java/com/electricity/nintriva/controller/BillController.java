package com.electricity.nintriva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.nintriva.model.BillDetails;
import com.electricity.nintriva.service.BillService;


@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired 
	BillService billService;
	
	@PostMapping(value="/submit")
	public ResponseEntity<String> submitBill(@RequestBody BillDetails billInputDetails) { 
		
	  String response = billService.submitBill(billInputDetails);
	  return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{consumerNumber}/{date}")
	public ResponseEntity<BillDetails> getUserBill(@PathVariable String consumerNumber, @PathVariable String date) { 
		
		BillDetails response = billService.generateBill(consumerNumber, date);
		return new ResponseEntity<BillDetails>(response,HttpStatus.OK);
	  
	}
	
	
}

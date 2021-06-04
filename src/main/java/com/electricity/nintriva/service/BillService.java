package com.electricity.nintriva.service;

import com.electricity.nintriva.model.BillDetails;

public interface BillService {
	
	//public BillResponse getBill(BillRequest billRequest);
	
	public String submitBill(BillDetails billInputDetails);
	public BillDetails generateBill(String consumerNumber,String date);
	
}

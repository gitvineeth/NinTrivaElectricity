package com.electricity.nintriva.service;

import com.electricity.nintriva.model.BillInputDetails;

public interface BillService {
	
	//public BillResponse getBill(BillRequest billRequest);
	
	public String submitBill(BillInputDetails billInputDetails);
	
}

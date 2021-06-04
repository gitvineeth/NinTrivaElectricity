package com.electricity.nintriva.response;

import java.time.LocalDate;

public class BillResponse {
	         
     private int billNumber;
	 private int consumerNumber;
	 private int consumedUnits;
	 private int billAmount;
	 private LocalDate billDate;
	public BillResponse(int billNumber, int consumerNumber, int consumedUnits, int billAmount, LocalDate billDate) {
		super();
		this.billNumber = billNumber;
		this.consumerNumber = consumerNumber;
		this.consumedUnits = consumedUnits;
		this.billAmount = billAmount;
		this.billDate = billDate;
	}
	
	public BillResponse() {
		super();
	}

	public int getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public int getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(int consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public int getConsumedUnits() {
		return consumedUnits;
	}
	public void setConsumedUnits(int consumedUnits) {
		this.consumedUnits = consumedUnits;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	public LocalDate getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}
	 
	 
	 



}

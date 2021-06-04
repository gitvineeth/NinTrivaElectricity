package com.electricity.nintriva.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bill_details")
public class BillDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8548034648634657704L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billNumber;
	
	@Column
    private int consumerNumber;
	
	@Column
	private int consumedUnits;
	
	@Column
	private int billAmount;
	
	@Column
	private LocalDate billDate;
	
	@Column
	private int currentReading;
	
	public BillDetails(int billNumber, int consumerNumber, int consumedUnits, int billAmount, LocalDate billDate) {
		super();
		this.billNumber = billNumber;
		this.consumerNumber = consumerNumber;
		this.consumedUnits = consumedUnits;
		this.billAmount = billAmount;
		this.billDate = billDate;
	}

	public BillDetails() {
		super();
	}


	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	

	public int getCurrentReading() {
		return currentReading;
	}

	public void setCurrentReading(int currentReading) {
		this.currentReading = currentReading;
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

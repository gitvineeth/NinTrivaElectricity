package com.electricity.nintriva.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="price_slab_details")
public class PriceSlabDetails {
	
	@Id
	private String slabName;
	
	private int unitSlab;
	
	private int perUnitPrice;
	
	

	public PriceSlabDetails(String slabName, int unitSlab, int perUnitPrice) {
		super();
		this.slabName = slabName;
		this.unitSlab = unitSlab;
		this.perUnitPrice = perUnitPrice;
	}

	
	public PriceSlabDetails() {
		super();
	}


	public String getSlabName() {
		return slabName;
	}

	public void setSlabName(String slabName) {
		this.slabName = slabName;
	}

	public int getUnitSlab() {
		return unitSlab;
	}

	public void setUnitSlab(int unitSlab) {
		this.unitSlab = unitSlab;
	}

	public int getPerUnitPrice() {
		return perUnitPrice;
	}

	public void setPerUnitPrice(int perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}
	
	
	
	
	
	
	
	
	

}

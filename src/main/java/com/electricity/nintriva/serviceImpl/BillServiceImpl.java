package com.electricity.nintriva.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.electricity.nintriva.entity.PriceSlabDetails;
import com.electricity.nintriva.model.BillInputDetails;
import com.electricity.nintriva.repository.BillRepository;
import com.electricity.nintriva.repository.PriceSlabRepository;
import com.electricity.nintriva.service.BillService;

@Component
public class BillServiceImpl implements BillService {

	@Autowired
   PriceSlabRepository priceSlabRepository;
	
	@Autowired
	BillRepository billRepository;
	
	
	
	@Override
	public String submitBill(BillInputDetails billInputDetails) {
	
		int billAmount = 0;
		List<Integer> unitList = new ArrayList<Integer>();
		List<PriceSlabDetails> detailList = (List<PriceSlabDetails>) priceSlabRepository.findAll();     
		
		detailList.forEach(item -> unitList.add(item.getUnitSlab()));
		Collections.sort(unitList);
		
		Optional<PriceSlabDetails> finalPriceSlab = getUnitSlab(unitList, detailList, billInputDetails.getConsumedUnits());
	    if(finalPriceSlab.isPresent()) {
	    	billAmount = finalPriceSlab.get().getPerUnitPrice() * billInputDetails.getConsumedUnits();
	    	
	    }
		billInputDetails.setBillAmount(billAmount);
		billInputDetails.setBillDate(LocalDate.now());
		billRepository.save(billInputDetails);
	
		return null;
	}



	private Optional<PriceSlabDetails> getUnitSlab(List<Integer> unitList, List<PriceSlabDetails> detailList,
			int consumedUnits) {
		
		int tempUnits;
		if(unitList.contains(consumedUnits)) {
			
			tempUnits = consumedUnits;
		} 
		
		
		else {
			List<Integer> list = unitList.stream().filter(s -> consumedUnits > s ).collect(Collectors.toList());
			Collections.sort(list);
		    tempUnits = list.get(list.size()-1);	
		}
		return detailList.stream().filter(i -> i.getUnitSlab() == tempUnits).findFirst();
		
			
		
		
	}
	
	
	

}

package com.electricity.nintriva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.electricity.nintriva.entity.PriceSlabDetails;
@Repository
public interface PriceSlabRepository extends CrudRepository<PriceSlabDetails, String> {
	
	  

}

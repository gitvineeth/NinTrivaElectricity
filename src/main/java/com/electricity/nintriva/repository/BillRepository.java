package com.electricity.nintriva.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.electricity.nintriva.model.BillDetails;


@Repository
public interface BillRepository extends CrudRepository<BillDetails, Integer> {
	
	
	/*Query*/
	/*("from bill_details b  where b.consumer_number = :consumerNumber having YEAR(b.bill_date) = :year and MONTH(b.bill_date) = :month")
	public BillDetails findUserBill(@Param("consumerNumber")int consumerNumber, @Param("month") int month,@Param("year") int year);
//*/  @Transactional
	@Query
	(nativeQuery =true,value="select * from bill_details b  where b.consumer_number =?1 having YEAR(b.bill_date) =?3 and MONTH(b.bill_date) = ?2")
	public BillDetails findUserBill(int consumerNumber, int month, int year);
    
	@Query(nativeQuery=true, value= "select * from bill_details where consumer_number = ?1 order by bill_date desc limit 1")
    public BillDetails findPreviousBill(int consumerNumber);
	

	
	
	
}

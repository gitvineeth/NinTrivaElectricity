package com.electricity.nintriva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.electricity.nintriva.model.BillInputDetails;

@Repository
public interface BillRepository extends CrudRepository<BillInputDetails, Integer> {

}

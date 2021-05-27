package com.electricity.nintriva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.electricity.nintriva.entity.RegistrationEntity;
@Repository
public interface RegistrationRepository extends CrudRepository<RegistrationEntity,Integer>{

}

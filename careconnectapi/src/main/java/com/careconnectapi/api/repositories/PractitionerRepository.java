package com.careconnectapi.api.repositories;

import java.util.List;

 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.careconnectapi.api.entity.PractitionerEntity;
import com.careconnectapi.api.model.PractitionerRequestBody;
 
@Repository
public interface  PractitionerRepository extends CrudRepository<PractitionerEntity,Integer> {

	@Query(value = "select * from  asutosh_doctors ", nativeQuery = true)
	Page<PractitionerEntity> listallusersfromdb(Pageable pageable);

	@Query(value = "SELECT count(*) from asutosh_doctors", nativeQuery = true)
	String countNumberOfPractitioners();



}

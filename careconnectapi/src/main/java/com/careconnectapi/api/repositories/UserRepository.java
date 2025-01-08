package com.careconnectapi.api.repositories;

import java.util.List;

 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.careconnectapi.api.entity.UserEntity;
import com.careconnectapi.api.model.UserRequestBody;
 
@Repository
public interface  UserRepository extends CrudRepository<UserEntity,Integer> {

	@Query(value = "select * from  asutosh_patient ", nativeQuery = true)
	Page<UserEntity> listAllUsers(Pageable pageable);

	@Query(value = "SELECT count(*) from asutosh_patient", nativeQuery = true)
	String countNumberOfUsers();

	@Query(value = "SELECT patientId FROM asutosh_patient WHERE firstName = :user and passWord= :pass", nativeQuery = true)
	Integer authenticate(@Param("user") String user,@Param("pass") String pass);

}

package com.careconnectapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.careconnectapi.api.entity.FeedbackEntity;
import com.careconnectapi.api.entity.StatusEntity;

@Repository
public interface StatusRepository extends CrudRepository<StatusEntity, Integer> {

    @Query(value = "SELECT * FROM asutosh_status ORDER BY status_id DESC", nativeQuery = true)
    Page<StatusEntity> findAll(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM asutosh_status", nativeQuery = true)
    long count();
    
//    @Query(value = "SELECT * FROM asutosh_status WHERE appointmentID = :appointment_id", nativeQuery = true)
//    Page<StatusEntity> findByAppointmentId(@Param("appointment_id") int appointment_id, Pageable pageable);
    @Query(value = "SELECT * FROM asutosh_status WHERE appointmentID = :appointment_id", nativeQuery = true)
    StatusEntity findByAppointmentId(@Param("appointment_id") int appointment_id);
}

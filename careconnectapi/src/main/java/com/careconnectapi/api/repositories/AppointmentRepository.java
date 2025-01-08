package com.careconnectapi.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.careconnectapi.api.entity.AppointmentEntity;
import com.careconnectapi.api.entity.StatusEntity;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Integer> {

    @Query(value = "SELECT * FROM asutosh_appointment ORDER BY appointmentId DESC", nativeQuery = true)
    Page<AppointmentEntity> findAll(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM asutosh_appointment", nativeQuery = true)
    long count();
    
    @Query(value = "SELECT * FROM asutosh_appointment WHERE doctorID = :id", nativeQuery = true)
    Page<AppointmentEntity> findByDocId(@Param("id") int id, Pageable pageable);
    
    @Query(value = "SELECT * FROM asutosh_appointment WHERE patientID = :id ORDER BY appointmentId DESC", nativeQuery = true)
    Page<AppointmentEntity> findByPatientId(@Param("id") int id, Pageable pageable);
    
    @Query(value = "SELECT max(appointmentID) FROM asutosh_appointment", nativeQuery = true)
    int id();
}
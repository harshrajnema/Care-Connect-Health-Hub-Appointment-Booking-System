package com.careconnectapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.careconnectapi.api.entity.FeedbackEntity;

@Repository
public interface FeedbackRepository extends PagingAndSortingRepository<FeedbackEntity, Integer> {

    @Query(value = "SELECT * FROM asutosh_feedback ORDER BY feedback_id DESC", nativeQuery = true)
    Page<FeedbackEntity> findAll(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM asutosh_feedback", nativeQuery = true)
    long count();
    
    @Query(value = "SELECT * FROM asutosh_feedback WHERE appointmentID = :appointment_id", nativeQuery = true)
    FeedbackEntity findByAppointmentId(@Param("appointment_id") int appointment_id);
   
}
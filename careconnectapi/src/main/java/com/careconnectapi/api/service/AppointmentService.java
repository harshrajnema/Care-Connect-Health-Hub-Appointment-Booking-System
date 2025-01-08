package com.careconnectapi.api.service;

import com.careconnectapi.api.entity.AppointmentEntity;
import com.careconnectapi.api.entity.StatusEntity;
import com.careconnectapi.api.model.AppointmentRequestBody;
import com.careconnectapi.api.model.PractitionerIdRequest;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.repositories.AppointmentRepository;
import com.careconnectapi.api.repositories.StatusRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository AppointmentRepository;

    
    public AppointmentEntity createAppointment(AppointmentRequestBody appointmentRequestBody) {
    	AppointmentEntity newAppointment = new AppointmentEntity();
    	newAppointment.setDoctorId(appointmentRequestBody.getDoctorId());
    	newAppointment.setPatientId(appointmentRequestBody.getPatientId());
    	 newAppointment.setAppointmentDate(appointmentRequestBody.getAppointmentDate());
    	  newAppointment.setAppointmentTime(appointmentRequestBody.getAppointmentTime());
    	  newAppointment.setStatus("pending");
    	  newAppointment.setReasonForVisit(appointmentRequestBody.getReasonForVisit());
    	  newAppointment.setCreatedAt(LocalDateTime.now());
//    	  newAppointment.setState("The doctor is busy");
    	  return AppointmentRepository.save(newAppointment);
    }
    
    public AppointmentEntity updateAppointment(AppointmentRequestBody appointmentRequestBody) {
    	AppointmentEntity newAppointment = new AppointmentEntity();
    	newAppointment.setAppointmentId(appointmentRequestBody.getAppointmentId());
    	newAppointment.setDoctorId(appointmentRequestBody.getDoctorId());
    	newAppointment.setPatientId(appointmentRequestBody.getPatientId());
    	 newAppointment.setAppointmentDate(appointmentRequestBody.getAppointmentDate());
    	  newAppointment.setAppointmentTime(appointmentRequestBody.getAppointmentTime());
    	  newAppointment.setStatus(appointmentRequestBody.getStatus());
    	  newAppointment.setReasonForVisit(appointmentRequestBody.getReasonForVisit());
    	  newAppointment.setCreatedAt(LocalDateTime.now());
//    	  newAppointment.setState(appointmentRequestBody.getState());
    	  return AppointmentRepository.save(newAppointment);
    }

    public Page<AppointmentEntity> listAllAppointments(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return AppointmentRepository.findAll(pageable);
    }

    public String deleteAppointment(AppointmentIdRequest AppointmentIdRequest) {
        AppointmentRepository.deleteById(AppointmentIdRequest.getAppointmentId());
        return "Appointment Deleted";
    }

    public long countNumberOfAppointments() {
        return AppointmentRepository.count();
    }
    
    public AppointmentEntity getAppointmentById(AppointmentIdRequest IdRequest) {
        return AppointmentRepository.findById(IdRequest.getAppointmentId())
            .orElseThrow(() -> new RuntimeException("Appointment not found for ID: " + IdRequest.getAppointmentId()));
    }
     
    public Page<AppointmentEntity> findByDoctorId(PractitionerIdRequest idRequest) {
        Pageable pageable = PageRequest.of(0,10);
        return AppointmentRepository.findByDocId(idRequest.getDoctorId(),pageable);
    }
    public Page<AppointmentEntity> findByPatientId(int id) {
        Pageable pageable = PageRequest.of(0,10);
        return AppointmentRepository.findByPatientId(id,pageable);
    }
    
    
    
    public String deleteByAppointment(int id) {
		//int PractitionerId= user.getDoctorId();
		AppointmentRepository.deleteById(id);
		return "Appointment Deleted";
	}
    
    public AppointmentEntity getWithAppointment(int id) {
        return AppointmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Appointment not found for ID: " + id));
    }
    public int getId() {
    	return AppointmentRepository.id();
    }
}
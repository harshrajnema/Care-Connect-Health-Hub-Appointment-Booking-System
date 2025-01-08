package com.careconnectapi.api.service;

import com.careconnectapi.api.entity.AppointmentEntity;
import com.careconnectapi.api.entity.FeedbackEntity;
import com.careconnectapi.api.entity.StatusEntity;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.model.StatusIdRequest;
import com.careconnectapi.api.model.StatusRequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.careconnectapi.api.repositories.AppointmentRepository;
import com.careconnectapi.api.repositories.StatusRepository;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private AppointmentRepository aptR;

    // Create a new appointment status
//    public StatusEntity createStatus(StatusRequestBody statusRequestBody) {
//        StatusEntity newStatus= new StatusEntity();
//        newStatus.setAppointmentId(statusRequestBody.getAppointmentId());
//        newStatus.setStatus(statusRequestBody.getStatus());
//        newStatus.setReason(statusRequestBody.getReason());
//        newStatus.setCreatedAt(LocalDateTime.now());
//        newStatus.setUpdatedAt(LocalDateTime.now());
//        return statusRepository.save(newStatus);
//    }
    public String createStatus(StatusRequestBody statusRequestBody) {
        StatusEntity newStatus= new StatusEntity();
        newStatus.setAppointmentId(aptR.id());
        newStatus.setStatus(statusRequestBody.getStatus());
        newStatus.setReason(statusRequestBody.getReason());
        newStatus.setCreatedAt(LocalDateTime.now());
        newStatus.setUpdatedAt(LocalDateTime.now());
         statusRepository.save(newStatus);
         return "Status recorded";
    }

    

    // Update an existing appointment status
    public StatusEntity updateStatus(StatusRequestBody statusRequestBody) {
        StatusEntity updatedStatus = new StatusEntity();
        updatedStatus.setStatusId(statusRequestBody.getStatusId());
        updatedStatus.setAppointmentId(statusRequestBody.getAppointmentId());
       updatedStatus.setStatus(statusRequestBody.getStatus());
       updatedStatus.setReason(statusRequestBody.getReason());
        updatedStatus.setCreatedAt(LocalDateTime.now());
        updatedStatus.setUpdatedAt(LocalDateTime.now());
        return statusRepository.save(updatedStatus);
    }


    // List all appointment statuses with pagination
    public Page<StatusEntity> listAllStatus(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return statusRepository.findAll(pageable);
    }

    // Delete an appointment status by ID
    public String deleteStatus(StatusIdRequest status) {
        statusRepository.deleteById(status.getStatusId());
        return "Appointment Status Deleted Successfully";
    }

    // Get the total number of appointment statuses
    public long countNumberOfStatus() {
        return statusRepository.count();
    }
    
//    public Page<StatusEntity> getRecordByAppointmentId(AppointmentIdRequest IdRequest){
//    	Pageable pageable = PageRequest.of(0,10);
//        return statusRepository.findByAppointmentId(IdRequest.getAppointmentId(), pageable);
//    }
    
    
    
    public String deleteByStatus(int id) {
		//int PractitionerId= user.getDoctorId();
		statusRepository.deleteById(id);
		return "Status Deleted";
	}
    
    public StatusEntity getWithStatus(int id) {
        return statusRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Status not found for ID: " + id));
    }
    
    public List<StatusEntity> getRecordByAppointmentId(String ids){
//    	Pageable pageable = PageRequest.of(0,1);
    	String[] arr = ids.split(",");
    	List<StatusEntity> entities = new ArrayList<>();
//    	int[] iDs = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
        	StatusEntity entity = statusRepository.findByAppointmentId(Integer.parseInt(arr[i]));
            if (entity != null) { // Check for null
                entities.add(entity);
//        	entities.add(statusRepository.findByAppointmentId(Integer.parseInt(arr[i])));
        }
            }
        return entities;
    }
}
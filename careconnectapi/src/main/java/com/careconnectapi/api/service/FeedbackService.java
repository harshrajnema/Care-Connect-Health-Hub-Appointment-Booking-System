package com.careconnectapi.api.service;


import com.careconnectapi.api.entity.FeedbackEntity;
import com.careconnectapi.api.entity.StatusEntity;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.model.FeedbackIdRequest;
import com.careconnectapi.api.model.FeedbackRequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.careconnectapi.api.repositories.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Create a new appointment feedback
    public FeedbackEntity createFeedback(FeedbackRequestBody feedbackRequestBody) {
        //validateFeedbackRequest(feedbackRequestBody);

        FeedbackEntity newFeedback = new FeedbackEntity();
        newFeedback.setAppointmentId(feedbackRequestBody.getAppointmentId());
        newFeedback.setRating(feedbackRequestBody.getRating());
        newFeedback.setComment(feedbackRequestBody.getComment());
        // Optional: Set creation timestamp
        newFeedback.setCreatedAt(LocalDateTime.now());
        return feedbackRepository.save(newFeedback);
    }

    // List all appointment feedbackes with pagination
    public Page<FeedbackEntity> listAllFeedback(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return feedbackRepository.findAll(pageable);
    }

    // Delete an appointment feedback by ID
    public String deleteFeedback(FeedbackIdRequest feedback) {
        feedbackRepository.deleteById(feedback.getFeedbackId());
        return "Appointment Feedback Deleted Successfully";
    }

    // Get the total number of appointment feedbackes
    public long countNumberOfFeedback() {
        return feedbackRepository.count();
    }
    public List<FeedbackEntity> getRecordByAppointmentId(String ids){
//    	Pageable pageable = PageRequest.of(0,1);
    	String[] arr = ids.split(",");
    	List<FeedbackEntity> entities = new ArrayList<>();
//    	int[] iDs = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
        	FeedbackEntity entity = feedbackRepository.findByAppointmentId(Integer.parseInt(arr[i]));
            if (entity != null) { // Check for null
                entities.add(entity);
//        	entities.add(feedbackRepository.findByAppointmentId(Integer.parseInt(arr[i])));
        }
        }
//         feedbackRepository.findByAppointmentId(ids);
         return entities;
    }
    
    public String deleteByFeedback(int id) {
		//int PractitionerId= user.getDoctorId();
		feedbackRepository.deleteById(id);
		return "Feedback Deleted";
	}
    
    public FeedbackEntity getWithFeedback(int id) {
        return feedbackRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Status not found for ID: " + id));
    }
}
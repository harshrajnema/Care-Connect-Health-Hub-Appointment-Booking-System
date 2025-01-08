package com.careconnectapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.careconnectapi.api.model.FeedbackRequestBody;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.model.FeedbackIdRequest;
import com.careconnectapi.api.service.FeedbackService;

@RestController
@CrossOrigin
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Create a new feedback
    @RequestMapping(value = "/createFeedback", method = RequestMethod.POST)
    public ResponseEntity<?> createAppointmentFeedback(@RequestBody FeedbackRequestBody feedbackRequestBody) throws Exception {
        return ResponseEntity.ok(feedbackService.createFeedback(feedbackRequestBody));
    }

    // List all feedback with pagination
    @RequestMapping(value = "/listAllFeedback", method = RequestMethod.GET)
    public ResponseEntity<?> listAllAppointmentFeedbacks(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                                 @RequestParam(defaultValue = "100") final Integer size) throws Exception {
        return ResponseEntity.ok(feedbackService.listAllFeedback(pageNumber, size));
    }

    // Delete an feedback by ID
    @RequestMapping(value = "/deleteFeedback", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAppointmentFeedback(@RequestBody FeedbackIdRequest feedbackIdRequest) throws Exception {
        return ResponseEntity.ok(feedbackService.deleteFeedback(feedbackIdRequest));
    }

    // Get the total number of feedback
    @RequestMapping(value = "/countFeedback", method = RequestMethod.GET)
    public ResponseEntity<?> countAppointmentFeedbacks() throws Exception {
        return ResponseEntity.ok(feedbackService.countNumberOfFeedback());
    }
    
    @RequestMapping(value = "/feedbackByAppointmentId/{ids}", method = RequestMethod.GET)
    public ResponseEntity<?> getByAppointmentId(@RequestBody @PathVariable("ids") String ids) throws Exception {
        return ResponseEntity.ok(feedbackService.getRecordByAppointmentId(ids));
    }
    
    
    @RequestMapping(value = "/deleteByFeedbackId/{feedbackId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteFeedbackById(@RequestBody @PathVariable("feedbackId") int id) throws Exception {
		return ResponseEntity.ok(feedbackService.deleteByFeedback(id));
	}
    
    @RequestMapping(value = "/getFeedbackWithId/{feedbackId}", method = RequestMethod.GET)
   	public ResponseEntity<?> getStatusWithId(@RequestBody @PathVariable("feedbackId") int id) throws Exception {
   		return ResponseEntity.ok(feedbackService.getWithFeedback(id));
   	}
}
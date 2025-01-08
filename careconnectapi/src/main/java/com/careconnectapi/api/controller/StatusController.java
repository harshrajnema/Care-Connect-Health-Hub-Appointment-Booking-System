package com.careconnectapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.careconnectapi.api.model.StatusRequestBody;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.model.StatusIdRequest;
import com.careconnectapi.api.service.StatusService;

@RestController
@CrossOrigin
public class StatusController {

    @Autowired
    private StatusService statusService;

    // Create a new status
//    @RequestMapping(value = "/makeStatus", method = RequestMethod.POST)
//    public ResponseEntity<?> createAppointmentStatus(@RequestBody StatusRequestBody statusRequestBody) throws Exception {
//        return ResponseEntity.ok(statusService.createStatus(statusRequestBody));
//    }
    @RequestMapping(value = "/makeStatus", method = RequestMethod.POST)
    public String createAppointmentStatus(@RequestBody StatusRequestBody statusRequestBody) throws Exception {
        return statusService.createStatus(statusRequestBody);
    }

    // Update an existing status
    @RequestMapping(value = "/updateStatus", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAppointmentStatus(@RequestBody StatusRequestBody statusRequestBody) throws Exception {
        return ResponseEntity.ok(statusService.updateStatus(statusRequestBody));
    }

    // List all status with pagination
    @RequestMapping(value = "/listAllStatus", method = RequestMethod.GET)
    public ResponseEntity<?> listAllAppointmentStatus(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                                 @RequestParam(defaultValue = "100") final Integer size) throws Exception {
        return ResponseEntity.ok(statusService.listAllStatus(pageNumber, size));
    }

    // Delete an status by ID
    @RequestMapping(value = "/deleteStatus", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAppointmentStatus(@RequestBody StatusIdRequest statusIdRequest) throws Exception {
        return ResponseEntity.ok(statusService.deleteStatus(statusIdRequest));
    }

    // Get the total number of status
    @RequestMapping(value = "/countStatus", method = RequestMethod.GET)
    public ResponseEntity<?> countAppointmentStatuss() throws Exception {
        return ResponseEntity.ok(statusService.countNumberOfStatus());
    }
    
//    @RequestMapping(value = "/statusByAppointmentId", method = RequestMethod.GET)
//    public ResponseEntity<?> getByAppointmentId(@RequestBody AppointmentIdRequest IdRequest) throws Exception {
//        return ResponseEntity.ok(statusService.getRecordByAppointmentId(IdRequest));
//    }
    @RequestMapping(value = "/statusByAppointmentId/{ids}", method = RequestMethod.GET)
    public ResponseEntity<?> getByAppointmentId(@RequestBody @PathVariable("ids") String ids) throws Exception {
        return ResponseEntity.ok(statusService.getRecordByAppointmentId(ids));
    }
    
    @RequestMapping(value = "/deleteByStatusId/{statusId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStatusById(@RequestBody @PathVariable("statusId") int id) throws Exception {
		return ResponseEntity.ok(statusService.deleteByStatus(id));
	}
    
    @RequestMapping(value = "/getStatusWithId/{statusId}", method = RequestMethod.GET)
   	public ResponseEntity<?> getStatusWithId(@RequestBody @PathVariable("statusId") int id) throws Exception {
   		return ResponseEntity.ok(statusService.getWithStatus(id));
   	}
}
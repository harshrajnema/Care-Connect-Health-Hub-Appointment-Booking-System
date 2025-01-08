package com.careconnectapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.careconnectapi.api.model.AppointmentRequestBody;
import com.careconnectapi.api.model.PractitionerIdRequest;
import com.careconnectapi.api.repositories.AppointmentRepository;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.service.AppointmentService;

@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    private AppointmentRepository appointmentRepo;

    // Create a new appointment
    @RequestMapping(value = "/makeAppointment", method = RequestMethod.POST)
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentRequestBody appointmentRequestBody) throws Exception {
        return ResponseEntity.ok(appointmentService.createAppointment(appointmentRequestBody));
    }

    // Update an existing appointment
    @RequestMapping(value = "/updateAppointment", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentRequestBody appointmentRequestBody) throws Exception {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointmentRequestBody));
    }

    // List all appointments with pagination
    @RequestMapping(value = "/listAllAppointments", method = RequestMethod.GET)
    public ResponseEntity<?> listAllAppointments(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                                 @RequestParam(defaultValue = "100") final Integer size) throws Exception {
        return ResponseEntity.ok(appointmentService.listAllAppointments(pageNumber, size));
    }

    // Delete an appointment by ID
    @RequestMapping(value = "/deleteAppointment", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAppointment(@RequestBody AppointmentIdRequest appointmentIdRequest) throws Exception {
        return ResponseEntity.ok(appointmentService.deleteAppointment(appointmentIdRequest));
    }

    // Get the total number of appointments
    @RequestMapping(value = "/Appointmentscount", method = RequestMethod.GET)
    public ResponseEntity<?> countAppointments() throws Exception {
        return ResponseEntity.ok(appointmentService.countNumberOfAppointments());
    }
    
    @RequestMapping(value = "/getAppointment", method = RequestMethod.GET)
    public ResponseEntity<?> getAppointmentById(@RequestBody AppointmentIdRequest appointmentIdRequest) throws Exception {
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentIdRequest));
    }
    
    @RequestMapping(value = "/getAppointmentByDocId", method = RequestMethod.GET)
    public ResponseEntity<?> getAppointmentByDocId(@RequestBody PractitionerIdRequest appointmentIdRequest) throws Exception {
        return ResponseEntity.ok(appointmentService.findByDoctorId(appointmentIdRequest));
    }
    
    @RequestMapping(value = "/getAppointmentByPatientId/{patientId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAppointmentByPatientId(@RequestBody @PathVariable("patientId") int id) throws Exception {
        return ResponseEntity.ok(appointmentService.findByPatientId(id));
    }
    
    @RequestMapping(value = "/deleteByAppointmentId/{appointmentId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAppointmentById(@RequestBody @PathVariable("appointmentId") int appointmentid) throws Exception {
		return ResponseEntity.ok(appointmentService.deleteByAppointment(appointmentid));
	}
    
    @RequestMapping(value = "/getAppointmentWithId/{appointmentId}", method = RequestMethod.GET)
   	public ResponseEntity<?> getAppointmentWithId(@RequestBody @PathVariable("appointmentId") int appointmentid) throws Exception {
   		return ResponseEntity.ok(appointmentService.getWithAppointment(appointmentid));
   	}
    
    @RequestMapping(value = "/getAppointmentID", method = RequestMethod.GET)
   	public ResponseEntity<?> getAppointmentID() throws Exception {
   		return ResponseEntity.ok(appointmentService.getId());
   	}
}
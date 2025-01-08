package com.careconnectapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.careconnectapi.api.model.PractitionerRequestBody;
import com.careconnectapi.api.model.PractitionerIdRequest;
import com.careconnectapi.api.service.PractitionerService;
  
@RestController
@CrossOrigin
public class PractitionerController {
	
	@Autowired
	private PractitionerService PractitionerService;	
	
	@RequestMapping(value = "/createPractitioner", method = RequestMethod.POST)
	public ResponseEntity<?> createPractitioner(@RequestBody PractitionerRequestBody PractitionerReqBody) throws Exception {
		return ResponseEntity.ok(PractitionerService.createPractitioner(PractitionerReqBody));
	}
	
	@RequestMapping(value = "/updatePractitioner", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePractitioner(@RequestBody PractitionerRequestBody PractitionerReqBody) throws Exception {
		return ResponseEntity.ok(PractitionerService.updatePractitioner(PractitionerReqBody));
	}		
	
	@RequestMapping(value = "/listAllPractitioners", method = RequestMethod.GET)
	public ResponseEntity<?> listAllPractitioners(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(PractitionerService.listallusersfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deletePractitioner", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePractitioner(@RequestBody PractitionerIdRequest user) throws Exception {
		return ResponseEntity.ok(PractitionerService.deletePractitioner(user));
	}		
	
	@RequestMapping(value = "/Practitionerscount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfPractitioners() throws Exception {
		return ResponseEntity.ok((PractitionerService.countNumberOfPractitioners()));
	}
	
	
	@RequestMapping(value = "/deleteByPractitionerId/{doctorId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePractitionerById(@RequestBody @PathVariable("doctorId") int practitionerid) throws Exception {
		return ResponseEntity.ok(PractitionerService.deleteByPractitioner(practitionerid));
	}
	
	
	@RequestMapping(value = "/getPractitionerById/{doctorId}", method = RequestMethod.GET)
	public ResponseEntity<?> getractitionerById(@RequestBody @PathVariable("doctorId") int practitionerid) throws Exception {
		return ResponseEntity.ok(PractitionerService.getByPractitioner(practitionerid));
	}
}

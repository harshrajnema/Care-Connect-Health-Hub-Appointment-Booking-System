package com.careconnectapi.api.service;

import com.careconnectapi.api.entity.PractitionerEntity;
import com.careconnectapi.api.entity.UserEntity;
import com.careconnectapi.api.model.PractitionerIdRequest;
import com.careconnectapi.api.model.PractitionerRequestBody; 
import com.careconnectapi.api.repositories.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class PractitionerService  {

	@Autowired
	private PractitionerRepository PractitionerRepository;

	

	public PractitionerEntity createPractitioner(PractitionerRequestBody practitionerRequestBodyObj) {

		PractitionerEntity newPractitioner = new PractitionerEntity();
		newPractitioner.setFirstName(practitionerRequestBodyObj.getFirstName());
		newPractitioner.setLastName(practitionerRequestBodyObj.getLastName());
		newPractitioner.setPhoneNumber(practitionerRequestBodyObj.getPhoneNumber());
		newPractitioner.setEmailId(practitionerRequestBodyObj.getEmailId());
		newPractitioner.setSpecialty(practitionerRequestBodyObj.getSpecialty());
		newPractitioner.setYearsOfExperience(practitionerRequestBodyObj.getYearsOfExperience());
		newPractitioner.setHospitalId(practitionerRequestBodyObj.getHospitalId());
		return PractitionerRepository.save(newPractitioner);		 
	}

	public PractitionerEntity updatePractitioner(PractitionerRequestBody practitionerRequestBodyObj) {
		PractitionerEntity newPractitioner = new PractitionerEntity();
		newPractitioner.setDoctorId(practitionerRequestBodyObj.getDoctorId() );
		newPractitioner.setFirstName(practitionerRequestBodyObj.getFirstName());
		newPractitioner.setLastName(practitionerRequestBodyObj.getLastName());
		newPractitioner.setPhoneNumber(practitionerRequestBodyObj.getPhoneNumber());
		newPractitioner.setEmailId(practitionerRequestBodyObj.getEmailId());
		newPractitioner.setSpecialty(practitionerRequestBodyObj.getSpecialty());
		newPractitioner.setYearsOfExperience(practitionerRequestBodyObj.getYearsOfExperience());
		newPractitioner.setHospitalId(practitionerRequestBodyObj.getHospitalId());
		return PractitionerRepository.save(newPractitioner);		 
	}

	public Page<PractitionerEntity> listallusersfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return PractitionerRepository.listallusersfromdb(pageable);
	}
 
	public String deletePractitioner(PractitionerIdRequest user) {
		int PractitionerId= user.getDoctorId();
		PractitionerRepository.deleteById(PractitionerId);
		return "Practitioner Deleted";
	}

	public String countNumberOfPractitioners() {

		return PractitionerRepository.countNumberOfPractitioners();
	}
	
	
	public String deleteByPractitioner(int id) {
		//int PractitionerId= user.getDoctorId();
		PractitionerRepository.deleteById(id);
		return "Practitioner Deleted";
	}
	
	public PractitionerEntity getByPractitioner(int id) {
		//int PractitionerId= user.getDoctorId();
		return PractitionerRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Practitioner not found for ID: " +id));
		
	}
}

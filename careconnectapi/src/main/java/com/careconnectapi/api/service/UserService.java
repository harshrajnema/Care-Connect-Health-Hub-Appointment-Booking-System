package com.careconnectapi.api.service;

import com.careconnectapi.api.entity.AppointmentEntity;
import com.careconnectapi.api.entity.UserEntity;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.model.UserIdRequest;
import com.careconnectapi.api.model.UserRequestBody; 
import com.careconnectapi.api.repositories.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class UserService  {

	@Autowired
	private UserRepository UserRepository;

	

	public UserEntity createUser(UserRequestBody userRequestBodyObj) {

		UserEntity newUser = new UserEntity();
		newUser.setFirstName(userRequestBodyObj.getFirstName());
		newUser.setLastName(userRequestBodyObj.getLastName());
		newUser.setPhoneNumber(userRequestBodyObj.getPhoneNumber());
		newUser.setEmailId(userRequestBodyObj.getEmailId());
		newUser.setPassWord(userRequestBodyObj.getPassWord());
		return UserRepository.save(newUser);		 
	}

	public UserEntity updateUser(UserRequestBody userRequestBodyObj) {
//		UserEntity newUser = new UserEntity();
//		newUser.setUserId(userRequestBodyObj.getUserId() );
		Optional<UserEntity> existingUserOptional = UserRepository.findById(userRequestBodyObj.getUserId());
	    
	    if (!existingUserOptional.isPresent()) {
	        throw new RuntimeException("User with ID " + userRequestBodyObj.getUserId() + " not found");
	    }

	    // Get the existing user entity
	    UserEntity newUser = existingUserOptional.get();
		newUser.setFirstName(userRequestBodyObj.getFirstName());
		newUser.setLastName(userRequestBodyObj.getLastName());
		newUser.setPhoneNumber(userRequestBodyObj.getPhoneNumber());
		newUser.setEmailId(userRequestBodyObj.getEmailId());
		newUser.setPassWord(userRequestBodyObj.getPassWord());
		return UserRepository.save(newUser);		 
	}
	
	public UserEntity getUserById(UserIdRequest IdRequest) {
        return UserRepository.findById(IdRequest.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found for ID: " + IdRequest.getUserId()));
	}
	public Page<UserEntity> listAllUsers(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return UserRepository.listAllUsers(pageable);
	}
 
	public String deleteUser(UserIdRequest user) {
		int UserId= user.getUserId();
		UserRepository.deleteById(UserId);
		return "User Deleted";
	}

	public String countNumberOfUsers() {

		return UserRepository.countNumberOfUsers();
	}

	
	public String deleteByUser(int id) {
		//int PractitionerId= user.getDoctorId();
		UserRepository.deleteById(id);
		return "User Deleted";
	}
	
	public UserEntity getWithUser(int id) {
		//int PractitionerId= user.getDoctorId();
		return UserRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found for ID: " +id));
		
	}
	
	public Integer getAuthenticate(String name,String password) {
		//int PractitionerId= user.getDoctorId();
		Integer res=UserRepository.authenticate(name,password);
		if(res>0 && res != null) {
			return res;
		}
		return null;
	}
}

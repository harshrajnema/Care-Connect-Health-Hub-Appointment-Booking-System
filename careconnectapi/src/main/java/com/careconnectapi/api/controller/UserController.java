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

import com.careconnectapi.api.model.UserRequestBody;
import com.careconnectapi.api.model.AppointmentIdRequest;
import com.careconnectapi.api.model.UserIdRequest;
import com.careconnectapi.api.service.UserService;
  
@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService UserService;	
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserRequestBody UserReqBody) throws Exception {
		return ResponseEntity.ok(UserService.createUser(UserReqBody));
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UserRequestBody UserReqBody) throws Exception {
		return ResponseEntity.ok(UserService.updateUser(UserReqBody));
	}		
	//Changed the code
	@RequestMapping(value = "/listAllUsers", method = RequestMethod.GET)
	public ResponseEntity<?> listAllUsers(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "100") final Integer size) throws Exception {
		return ResponseEntity.ok(UserService.listAllUsers(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestBody UserIdRequest user) throws Exception {
		return ResponseEntity.ok(UserService.deleteUser(user));
	}		
	
	@RequestMapping(value = "/usersCount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfUsers() throws Exception {
		return ResponseEntity.ok((UserService.countNumberOfUsers()));
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@RequestBody UserIdRequest IdRequest) throws Exception {
        return ResponseEntity.ok(UserService.getUserById(IdRequest));
    }
	
	
	@RequestMapping(value = "/deleteByUserId/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUserById(@RequestBody @PathVariable("userId") int userid) throws Exception {
		return ResponseEntity.ok(UserService.deleteByUser(userid));
	}
	
	@RequestMapping(value = "/getWithUserId/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getWithUserById(@RequestBody @PathVariable("userId") int userid) throws Exception {
		return ResponseEntity.ok(UserService.getWithUser(userid));
	}
	
	@RequestMapping(value = "/getAuthentication/{username}/{password}", method = RequestMethod.GET)
	public ResponseEntity<?> getAuthentication(@RequestBody @PathVariable("username") String username, @PathVariable("password") String password) throws Exception {
		return ResponseEntity.ok(UserService.getAuthenticate(username,password));
	}
}

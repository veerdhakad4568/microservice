package com.applearn.app.ws.controller;



import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.applearn.app.ws.exceptions.UserServiceException;
import com.applearn.app.ws.request.UserDetailRequest;
import com.applearn.app.ws.response.UserResponse;
import com.applearn.app.ws.userservice.UserService;

@RestController
@RequestMapping("users")
public class UserController {
    
	Map<String,UserResponse> users=new HashMap<String,UserResponse>();
	
	@Autowired
	private UserService userService;
	@GetMapping("/status")
	public ResponseEntity<String> status(){
		/*
		 * if(true) { throw new UserServiceException("User service Exception"); }
		 */
		return ResponseEntity.accepted().body("Working..");  
	}
	
	@GetMapping
	public ResponseEntity<String> getUsers(@RequestParam(value="page",defaultValue ="1") int page,
			@RequestParam(value="limit",defaultValue ="50") int limit,
			@RequestParam(value="order",defaultValue ="desc") int order){
		return ResponseEntity.accepted().body("get users " +page + " " +limit +" "+order);  
	}
	
	@GetMapping(path="/{userId}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<UserResponse> getUser(@PathVariable String userId){
		UserResponse userResponse=null;
		if(users.containsKey(userId)){
			userResponse=users.get(userId);
			return ResponseEntity.accepted().body(userResponse);  
		}
		return ResponseEntity.noContent().build();  
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserDetailRequest userDetailReq ){
		
		UserResponse userResponse =userService.createUser(userDetailReq);
		return ResponseEntity.accepted().body(userResponse);  
	}
	
	@PutMapping(path="/{userId}",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> updateUser(@PathVariable String userId,@Valid @RequestBody UserDetailRequest userDetailReq){
		UserResponse userResponse=users.get(userId);
		if(userDetailReq.getEmail().equals(userResponse.getEmail())){
			userResponse.setEmail(userDetailReq.getEmail());
		}
		return ResponseEntity.accepted().body("update user");  
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		users.remove(userId);
		return ResponseEntity.ok().body("delete user");  
	}
	
	
}

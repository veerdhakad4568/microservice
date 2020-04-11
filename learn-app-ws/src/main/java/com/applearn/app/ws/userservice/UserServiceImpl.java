package com.applearn.app.ws.userservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.applearn.app.ws.request.UserDetailRequest;
import com.applearn.app.ws.response.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	Map<String,UserResponse> users=new HashMap<String,UserResponse>(); 
	
	@Override
	public UserResponse createUser(UserDetailRequest userDetailReq) {
		UserResponse userResponse=new UserResponse();
		userResponse.setFirstName(userDetailReq.getFirstName());
		userResponse.setEmail(userDetailReq.getEmail());
		userResponse.setLastName(userDetailReq.getLastName());
		String id=UUID.randomUUID().toString();
		userResponse.setUserId(id);
		users.put(id, userResponse);
		return userResponse;
	}

}

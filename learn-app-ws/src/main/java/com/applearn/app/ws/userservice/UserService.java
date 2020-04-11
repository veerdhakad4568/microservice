package com.applearn.app.ws.userservice;

import com.applearn.app.ws.request.UserDetailRequest;
import com.applearn.app.ws.response.UserResponse;

public interface UserService {
   UserResponse createUser(UserDetailRequest user);
}

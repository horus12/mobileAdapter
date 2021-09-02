package com.tcc.mobileAdapter.mobileAdapter.controller.api;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.UserResponse;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface Authentication {

    @PostMapping("/login")
    ResponseEntity<UserResponse> login(@RequestBody AuthRequest authRequest);

    @PostMapping("/createUser")
    ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest);

}

package com.tcc.mobileAdapter.mobileAdapter.controller.api;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AuthResponse;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.CreateUserResponse;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@CrossOrigin
public interface Authentication {

    @PostMapping("/login")
    ResponseEntity<AuthResponse> execute(@RequestBody AuthRequest authRequest);

    @PostMapping("/createUser")
    ResponseEntity<CreateUserResponse> execute(@RequestBody CreateUserRequest createUserRequest);

}

package com.tcc.mobileAdapter.mobileAdapter.controller.api;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateInternalUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/internal")
public interface InternalAuthentication {

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody AuthRequest authRequest);

    @PostMapping("/create")
    ResponseEntity<?> createInternalUser(@RequestBody CreateInternalUserRequest request);

    @DeleteMapping("/delete/{userId}")
    ResponseEntity<?> deleteInternalUser(@PathVariable String userId);
}

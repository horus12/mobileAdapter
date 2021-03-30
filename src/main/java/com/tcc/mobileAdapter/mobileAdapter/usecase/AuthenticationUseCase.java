package com.tcc.mobileAdapter.mobileAdapter.usecase;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AuthResponse;
import com.tcc.mobileAdapter.mobileAdapter.data.UserRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthenticationUseCase {

    private final UserRepository userRepository;

    public AuthResponse execute(AuthRequest authRequest) throws Exception {
        Assert.hasText(authRequest.getUserName(), "UserName should not be null or empty");
        Assert.hasText(authRequest.getPassword(), "Password should not be null or empty");

        User user = userRepository.findByCpf(authRequest.getUserName());

        if (user != null) {
            if (user.getPassword().equals(authRequest.getPassword())) {
                return AuthResponse.builder().id(user.getId()).build();
            }
        } else {
            throw new Exception("unauthorized");
        }
        return null;
    }
}

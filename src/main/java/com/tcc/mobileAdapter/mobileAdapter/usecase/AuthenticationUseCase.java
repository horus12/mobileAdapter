package com.tcc.mobileAdapter.mobileAdapter.usecase;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationUseCase {

    public AuthResponse execute(AuthRequest authRequest){

        return null;
    }
}

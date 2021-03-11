package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.Authentication;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AuthResponse;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.CreateUserResponse;
import com.tcc.mobileAdapter.mobileAdapter.translator.Translator;
import com.tcc.mobileAdapter.mobileAdapter.usecase.AuthenticationUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.CreateUserUseCase;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequiredArgsConstructor
public class AuthenticationController implements Authentication {

    private final AuthenticationUseCase authenticationUseCase;

    private final CreateUserUseCase createUserUseCase;

    @Override
    public ResponseEntity<AuthResponse> execute(AuthRequest authRequest) {
        return new ResponseEntity<>(Translator.translate(authenticationUseCase.execute(authRequest), AuthResponse.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateUserResponse> execute(CreateUserRequest createUserRequest) {
        try {
            createUserUseCase.execute(createUserRequest);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

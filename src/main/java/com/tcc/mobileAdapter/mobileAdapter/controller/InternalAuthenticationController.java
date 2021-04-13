package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.InternalAuthentication;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AuthResponse;
import com.tcc.mobileAdapter.mobileAdapter.translator.Translator;
import com.tcc.mobileAdapter.mobileAdapter.usecase.AuthenticationUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.InternalAuthenticationUseCase;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Data
@CrossOrigin
@RequiredArgsConstructor
public class InternalAuthenticationController implements InternalAuthentication {

    private final InternalAuthenticationUseCase internalAuthenticationUseCase;

    @Override
    public ResponseEntity<AuthResponse> execute(AuthRequest authRequest) {
        AuthResponse auth;
        try {
            auth = internalAuthenticationUseCase.execute(authRequest);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            if (e.getMessage().equals("unauthorized"))
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            else
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (auth != null)
            return new ResponseEntity<>(Translator.translate(auth, AuthResponse.class), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

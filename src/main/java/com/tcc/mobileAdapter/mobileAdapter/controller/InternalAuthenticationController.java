package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.InternalAuthentication;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateInternalUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AuthResponse;
import com.tcc.mobileAdapter.mobileAdapter.exception.BaseException;
import com.tcc.mobileAdapter.mobileAdapter.translator.Translator;
import com.tcc.mobileAdapter.mobileAdapter.usecase.internaluser.CreateInternalUserUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.internaluser.DeleteInternalUserUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.internaluser.InternalAuthenticationUseCase;
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
    private final CreateInternalUserUseCase createInternalUserUseCase;
    private final DeleteInternalUserUseCase deleteInternalUserUseCase;

    @Override
    public ResponseEntity<?> login(AuthRequest authRequest) {
        AuthResponse auth;
        try {
            auth = internalAuthenticationUseCase.execute(authRequest);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (BaseException e) {
            return new ResponseEntity<>(e.exceptionErrorMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(Translator.translate(auth, AuthResponse.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createInternalUser(CreateInternalUserRequest request) {
        try {
            createInternalUserUseCase.execute(request);
        } catch (BaseException e) {
            return new ResponseEntity<>(e.exceptionErrorMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteInternalUser(String userId) {
        try {
            deleteInternalUserUseCase.execute(userId);
        } catch (BaseException e) {
            return new ResponseEntity<>(e.exceptionErrorMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

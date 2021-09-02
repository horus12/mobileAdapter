package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.Authentication;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.UserResponse;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import com.tcc.mobileAdapter.mobileAdapter.exception.AlreadyExistException;
import com.tcc.mobileAdapter.mobileAdapter.exception.BaseException;
import com.tcc.mobileAdapter.mobileAdapter.usecase.user.AuthenticationUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.user.CreateUserUseCase;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController implements Authentication {

    private final AuthenticationUseCase authenticationUseCase;

    private final CreateUserUseCase createUserUseCase;

    @Override
    public ResponseEntity<UserResponse> login(AuthRequest authRequest) {
        UserResponse user;
        try {
            user = authenticationUseCase.execute(authRequest);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            if (e.getMessage().equals("unauthorized"))
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            else
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createUser(CreateUserRequest createUserRequest) {
        UserResponse user;
        try {
            user = createUserUseCase.execute(createUserRequest);
        } catch (BaseException e) {
            return new ResponseEntity<>(e.exceptionErrorMessage(),HttpStatus.CONFLICT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (user != null) {
            return new ResponseEntity<>(user,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

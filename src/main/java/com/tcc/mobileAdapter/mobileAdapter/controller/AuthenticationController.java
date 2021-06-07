package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.Authentication;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import com.tcc.mobileAdapter.mobileAdapter.exception.AlreadyExistException;
import com.tcc.mobileAdapter.mobileAdapter.usecase.AuthenticationUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.CreateUserUseCase;
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
    public ResponseEntity<User> login(AuthRequest authRequest) {
        User user;
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
        User user;
        try {
            user = createUserUseCase.execute(createUserRequest);
        } catch (AlreadyExistException e) {
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

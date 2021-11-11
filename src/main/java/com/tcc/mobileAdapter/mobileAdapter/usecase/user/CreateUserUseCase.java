package com.tcc.mobileAdapter.mobileAdapter.usecase.user;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.UserResponse;
import com.tcc.mobileAdapter.mobileAdapter.data.user.UserRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import com.tcc.mobileAdapter.mobileAdapter.exception.AlreadyExistException;
import com.tcc.mobileAdapter.mobileAdapter.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public UserResponse execute(CreateUserRequest request) throws Exception {

        Assert.hasText(request.getUserName(), "UserName should not be null or empty");
        Assert.hasText(request.getCpf(), "cpf should not be null or empty");
        Assert.hasText(request.getPassword(), "Password should not be null or empty");
        Assert.hasText(request.getEmail(), "Email should not be null or empty");

        if (request.getPassword().length() < 6) {
            throw new BaseException("invalid_password");
        }

        if (userRepository.findByEmail(request.getEmail()) != null) {
            throw new AlreadyExistException("user_already_exists");
        }
        UserRecord fUser;
        try {
            fUser = FirebaseAuth.getInstance().createUser(new UserRecord.CreateRequest()
                    .setEmail(request.getEmail())
                    .setDisplayName(request.getUserName())
                    .setPassword(request.getPassword()));
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
        if (fUser == null)
            throw new BaseException("no_token");

        String authToken = FirebaseAuth.getInstance().createCustomToken(fUser.getUid());

        User user = User.builder().userName(request.getUserName())
                .contact(request.getContact())
                .cpf(request.getCpf())
                .CreatedDate(LocalDate.now())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        userRepository.save(user);

        return UserResponse.builder().user(user).token(fUser.getUid()).build();
    }
}

package com.tcc.mobileAdapter.mobileAdapter.usecase.user;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.UserResponse;
import com.tcc.mobileAdapter.mobileAdapter.data.user.UserRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
public class AuthenticationUseCase {

    private final UserRepository userRepository;

    public UserResponse execute(AuthRequest authRequest) throws Exception {
        Assert.hasText(authRequest.getUserName(), "UserName should not be null or empty");
        Assert.hasText(authRequest.getPassword(), "Password should not be null or empty");

        User user = userRepository.findByEmail(authRequest.getUserName());

        UserRecord fUser = FirebaseAuth.getInstance().getUserByEmail(authRequest.getUserName());

        if (fUser == null)
            throw new Exception("unauthorized");

        if (user != null) {
            if (user.getPassword().equals(authRequest.getPassword())) {
                return UserResponse.builder()
                        .token(fUser.getUid())
                        .user(user)
                        .build();
            }
        } else {
            throw new Exception("unauthorized");
        }
        return null;
    }
}

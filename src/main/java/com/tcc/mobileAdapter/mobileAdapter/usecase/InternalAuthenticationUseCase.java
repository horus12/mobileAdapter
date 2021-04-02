package com.tcc.mobileAdapter.mobileAdapter.usecase;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.AuthRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AuthResponse;
import com.tcc.mobileAdapter.mobileAdapter.data.internaluser.InternalUserRepository;
import com.tcc.mobileAdapter.mobileAdapter.data.user.UserRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.InternalUser;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
public class InternalAuthenticationUseCase {

    private final InternalUserRepository internalUserRepository;

    public AuthResponse execute(AuthRequest authRequest) throws Exception {
        Assert.hasText(authRequest.getUserName(), "UserName should not be null or empty");
        Assert.hasText(authRequest.getPassword(), "Password should not be null or empty");

        InternalUser iUser = InternalUser.builder().email(authRequest.getUserName()).password(authRequest.getPassword()).build();

        internalUserRepository.save(iUser);

        InternalUser user = internalUserRepository.findByEmail(authRequest.getUserName());

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

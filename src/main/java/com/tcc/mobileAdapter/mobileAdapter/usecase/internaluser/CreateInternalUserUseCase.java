package com.tcc.mobileAdapter.mobileAdapter.usecase.internaluser;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateInternalUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.internaluser.InternalUserRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.InternalUser;
import com.tcc.mobileAdapter.mobileAdapter.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
public class CreateInternalUserUseCase {
    private final InternalUserRepository internalUserRepository;

    public void execute(CreateInternalUserRequest request) throws BaseException {
        Assert.hasText(request.getEmail(), "Email should not be null or empty");
        Assert.hasText(request.getPassword(), "Password should not be null or empty");
        Assert.hasText(request.getRole(), "Role should not be null or empty");

        if (internalUserRepository.findByEmail(request.getEmail()) != null) {
            throw new BaseException("user_already_exist");
        }

        InternalUser newUser = InternalUser.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
        internalUserRepository.save(newUser);
    }
}

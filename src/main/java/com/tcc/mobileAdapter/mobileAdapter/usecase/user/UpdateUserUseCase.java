package com.tcc.mobileAdapter.mobileAdapter.usecase.user;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.UpdateUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.user.UserRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateUserUseCase {

    private final UserRepository userRepository;

    public User execute(UpdateUserRequest req){




        return null;
    }
}

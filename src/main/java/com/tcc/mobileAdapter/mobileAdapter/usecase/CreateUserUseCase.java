package com.tcc.mobileAdapter.mobileAdapter.usecase;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.CreateUserResponse;
import com.tcc.mobileAdapter.mobileAdapter.data.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserResponse execute(CreateUserRequest request){

        Assert.hasText(request.getUserName(), "UserName should not be null or empty");
        Assert.hasText(request.getCpf(), "cpf should not be null or empty");
        Assert.hasText(request.getPassword(), "Password should not be null or empty");
        Assert.hasText(request.getEmail(), "Email should not be null or empty");

        userRepository.save(null);

        return null;
    }
}

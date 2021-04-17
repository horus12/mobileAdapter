package com.tcc.mobileAdapter.mobileAdapter.usecase;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateUserRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.user.UserRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import com.tcc.mobileAdapter.mobileAdapter.exception.AlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public User execute(CreateUserRequest request) throws Exception {

        Assert.hasText(request.getUserName(), "UserName should not be null or empty");
        Assert.hasText(request.getCpf(), "cpf should not be null or empty");
        Assert.hasText(request.getPassword(), "Password should not be null or empty");
        Assert.hasText(request.getEmail(), "Email should not be null or empty");

        if (userRepository.findByCpf(request.getCpf()) != null) {
            throw new AlreadyExistException("Cpf_already_exists");
        }

        User user = User.builder().userName(request.getUserName())
                .contact(request.getContact())
                .cpf(request.getCpf())
                .CreatedDate(LocalDate.now())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        userRepository.save(user);

        return user;
    }
}

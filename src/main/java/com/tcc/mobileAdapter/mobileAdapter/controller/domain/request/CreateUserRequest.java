package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserRequest {

    @NonNull
    private String cpf;

    @NonNull
    private String password;

    @NonNull
    private String userName;

    @NonNull
    private String email;

    @NonNull
    private String contact;
}

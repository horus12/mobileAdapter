package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotNull
    private String cpf;

    @NotNull
    private String password;

    @NotNull
    private String userName;

    @NotNull
    private String email;

    @NotNull
    private String contact;
}

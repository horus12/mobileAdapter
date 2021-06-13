package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateInternalUserRequest {

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String role;
}

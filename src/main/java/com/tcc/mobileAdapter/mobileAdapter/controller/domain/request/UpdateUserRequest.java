package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import com.mongodb.lang.Nullable;
import lombok.Data;
import lombok.NonNull;

@Data

public class UpdateUserRequest {

    @NonNull
    private String cpf;

    @Nullable
    private String password;

    @Nullable
    private String userName;

    @Nullable
    private String email;

    @Nullable
    private String contact;
}

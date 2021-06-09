package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @NonNull
    String userName;

    @NonNull
    String password;

    @NonNull
    String role;
}
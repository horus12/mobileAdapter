package com.tcc.mobileAdapter.mobileAdapter.controller.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
@Getter
@Setter
public class UserResponse {
    String token;
    User user;
}

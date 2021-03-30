package com.tcc.mobileAdapter.mobileAdapter.controller.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
@Getter
@Setter
public class AuthResponse {
    String id;

    @Override
    public String toString() {
        return "{" +
                "id='" + id +
                '}';
    }
}

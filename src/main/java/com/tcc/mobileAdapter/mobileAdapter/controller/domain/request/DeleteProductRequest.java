package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class DeleteProductRequest {

    @NonNull
    private String id;
}

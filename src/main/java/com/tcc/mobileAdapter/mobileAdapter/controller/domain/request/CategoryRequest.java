package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class CategoryRequest {
    @NonNull
    private String category;

    @NonNull
    private String imgUrl;

    @NonNull
    private Boolean enabled;
}

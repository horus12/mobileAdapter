package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class CreateProductRequest {

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private String defaultImage;

    @NonNull
    private String type;

    @NonNull
    private Boolean enabled;

    private List<String> images;


}
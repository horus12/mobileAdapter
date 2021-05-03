package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class StockRequest {

    @NonNull
    private String productId;

    @NonNull
    private int quantity;

    @NonNull
    private Date dueDate;

    @NonNull
    private Double price;
}
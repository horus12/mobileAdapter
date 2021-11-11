package com.tcc.mobileAdapter.mobileAdapter.controller.domain.request;

import lombok.Data;

@Data
public class CreateDeliveryAddressRequest {

    private String userId;

    private String street;

    private String number;

    private String cep;

    private String district;
}

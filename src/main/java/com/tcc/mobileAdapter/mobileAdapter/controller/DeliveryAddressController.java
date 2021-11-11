package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.DeliveryAddressApi;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateDeliveryAddressRequest;
import com.tcc.mobileAdapter.mobileAdapter.usecase.deliveryaddress.CreateDeliveryAddress;
import com.tcc.mobileAdapter.mobileAdapter.usecase.deliveryaddress.GetDeliveryAddress;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@CrossOrigin
@RequiredArgsConstructor
public class DeliveryAddressController implements DeliveryAddressApi {

    private final CreateDeliveryAddress createDeliveryAddress;
//    private final GetDeliveryAddress getDeliveryAddress;

    @Override
    public ResponseEntity<?> createDeliveryAddress(CreateDeliveryAddressRequest createDeliveryAddressRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> getDeliveryAddress(String userId) {
        return null;
    }
}

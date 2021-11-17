package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.DeliveryAddressApi;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateDeliveryAddressRequest;
import com.tcc.mobileAdapter.mobileAdapter.usecase.deliveryaddress.CreateDeliveryAddress;
import com.tcc.mobileAdapter.mobileAdapter.usecase.deliveryaddress.GetDeliveryAddress;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@CrossOrigin
@RequiredArgsConstructor
public class DeliveryAddressController implements DeliveryAddressApi {

    private final CreateDeliveryAddress createDeliveryAddress;
    private final GetDeliveryAddress getDeliveryAddress;

    @Override
    public ResponseEntity<?> createDeliveryAddress(CreateDeliveryAddressRequest createDeliveryAddressRequest) {
        try {
            createDeliveryAddress.execute(createDeliveryAddressRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            if (e.getMessage().equals("invalid_token"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getDeliveryAddress(String userId) {
        try {
            return new ResponseEntity<>(getDeliveryAddress.execute(userId), HttpStatus.OK);
        } catch (Exception e) {
            if (e.getMessage().equals("invalid_token"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

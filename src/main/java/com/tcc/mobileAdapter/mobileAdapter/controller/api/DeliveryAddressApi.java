package com.tcc.mobileAdapter.mobileAdapter.controller.api;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateDeliveryAddressRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/deliveryAddress")
public interface  DeliveryAddressApi {

    @PostMapping
    ResponseEntity<?> createDeliveryAddress(@RequestBody CreateDeliveryAddressRequest createDeliveryAddressRequest);

    @GetMapping("/{userId}")
    ResponseEntity<?> getDeliveryAddress(@PathVariable String userId);
}

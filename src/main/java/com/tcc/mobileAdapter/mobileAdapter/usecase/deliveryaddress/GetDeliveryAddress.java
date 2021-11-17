package com.tcc.mobileAdapter.mobileAdapter.usecase.deliveryaddress;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateDeliveryAddressRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.deliveryaddress.DeliveryAddressMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.DeliveryAddress;
import com.tcc.mobileAdapter.mobileAdapter.util.TokenHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetDeliveryAddress {
    private final DeliveryAddressMongoRepository deliveryAddressRepository;
    private final TokenHelper tokenHelper;

    public DeliveryAddress execute(String userId) throws Exception {

        String email = tokenHelper.execute(userId);
        if (email == null) throw new Exception("invalid_token");

        return deliveryAddressRepository.findByUserId(userId);
    }
}

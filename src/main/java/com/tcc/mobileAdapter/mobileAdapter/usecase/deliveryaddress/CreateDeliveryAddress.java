package com.tcc.mobileAdapter.mobileAdapter.usecase.deliveryaddress;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateDeliveryAddressRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.deliveryaddress.DeliveryAddressMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.DeliveryAddress;
import com.tcc.mobileAdapter.mobileAdapter.util.TokenHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateDeliveryAddress {

    private final DeliveryAddressMongoRepository deliveryAddressRepository;
    private final TokenHelper tokenHelper;

    public void execute(CreateDeliveryAddressRequest request) throws Exception {

        String email = tokenHelper.execute(request.getUserId());
        if (email==null) throw new Exception("invalid_token");

        DeliveryAddress deliveryAddress = DeliveryAddress.builder()
                .district(request.getDistrict())
                .number(request.getNumber())
                .street(request.getStreet())
                .cep(request.getCep())
                .build();

        deliveryAddressRepository.save(deliveryAddress);
    }
}

package com.tcc.mobileAdapter.mobileAdapter.data.deliveryaddress;

import com.tcc.mobileAdapter.mobileAdapter.domain.DeliveryAddress;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryAddressMongoRepository extends MongoRepository<DeliveryAddress, String> {
}

package com.tcc.mobileAdapter.mobileAdapter.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "deliveryAddress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryAddress {

    @Id
    private String id;

    private String street;

    private String number;

    private String cep;

    private String district;

}

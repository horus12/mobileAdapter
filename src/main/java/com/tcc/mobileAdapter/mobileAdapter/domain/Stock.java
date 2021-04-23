package com.tcc.mobileAdapter.mobileAdapter.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "stock")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {

    @Id
    private String id;

    private Product product;

    private int quantity;

    private Date createdDate;

    private Date dueDate;

}

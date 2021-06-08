package com.tcc.mobileAdapter.mobileAdapter.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
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

    private String product;

    private int quantity;

    private LocalDate createdDate;

    private Date dueDate;

    private Double price;

}

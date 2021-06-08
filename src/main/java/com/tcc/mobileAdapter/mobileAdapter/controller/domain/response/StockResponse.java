package com.tcc.mobileAdapter.mobileAdapter.controller.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
@Data
@Getter
@Setter
public class StockResponse {

    @Id
    private String id;

    private Product product;

    private int quantity;

    private LocalDate createdDate;

    private Date dueDate;

    private Double price;
}

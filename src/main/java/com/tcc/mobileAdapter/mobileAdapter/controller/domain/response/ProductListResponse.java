package com.tcc.mobileAdapter.mobileAdapter.controller.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
@Data
@Getter
@Setter
public class ProductListResponse {

    List<Product> products;

    @Override
    public String toString() {
        return "{" +
                "Products='" + products +
                '}';
    }
}


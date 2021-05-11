package com.tcc.mobileAdapter.mobileAdapter.controller.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@Getter
@Setter
public class AvailableProductsResponse {

    private Product product;

    private int quantity;

    private Double price;

    public AvailableProductsResponse(AvailableProductsResponse newEntry) {
        this.product = newEntry.getProduct();
        this.quantity = newEntry.getQuantity();
        this.price = newEntry.getPrice();
    }

    public AvailableProductsResponse merge(AvailableProductsResponse mergeEntry) {
        quantity = quantity + mergeEntry.getQuantity();
        if (price < mergeEntry.getPrice())
            price = mergeEntry.getPrice();
        return this;
    }

    public String getProductId() {
        return product.getId();
    }
}

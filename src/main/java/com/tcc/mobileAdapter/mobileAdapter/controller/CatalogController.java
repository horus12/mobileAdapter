package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.CatalogApi;
import com.tcc.mobileAdapter.mobileAdapter.usecase.product.GetProductUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.stock.GetAvailableStockUseCase;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@CrossOrigin
@RequiredArgsConstructor
public class CatalogController implements CatalogApi {

    private final GetAvailableStockUseCase getAvailableStockUseCase;
    private final GetProductUseCase getProductUseCase;

    @Override
    public ResponseEntity<?> getProducts() {

        return new ResponseEntity<>(getAvailableStockUseCase.execute(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getProduct(String productId) {
        return new ResponseEntity<>(getProductUseCase.execute(productId), HttpStatus.OK);
    }
}

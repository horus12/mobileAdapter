package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.ProductApi;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateProductRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AuthResponse;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import com.tcc.mobileAdapter.mobileAdapter.translator.Translator;
import com.tcc.mobileAdapter.mobileAdapter.usecase.CreateProductUseCase;
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
public class ProductController implements ProductApi {

    private final CreateProductUseCase createProductUseCase;

    @Override
    public ResponseEntity<?> execute(CreateProductRequest createProductRequest) {
        Product auth;
        try {
            auth = createProductUseCase.execute(createProductRequest);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            if (e.getMessage().equals("Product_already_exists"))
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            else
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (auth != null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.ProductApi;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.ProductRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.ProductListResponse;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import com.tcc.mobileAdapter.mobileAdapter.exception.ProductNotFoundException;
import com.tcc.mobileAdapter.mobileAdapter.translator.Translator;
import com.tcc.mobileAdapter.mobileAdapter.usecase.product.CreateProductUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.product.DeleteProductUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.product.GetProductsUseCase;
import com.tcc.mobileAdapter.mobileAdapter.usecase.product.UpdateProductUseCase;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@CrossOrigin
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final CreateProductUseCase createProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final GetProductsUseCase getProductsUseCase;

    @Override
    public ResponseEntity<?> createProduct(ProductRequest productRequest) {
        Product product;
        try {
            product = createProductUseCase.execute(productRequest);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            if (e.getMessage().equals("Product_already_exists"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
            else
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (product != null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteProduct(String productId) {
        try {
            deleteProductUseCase.execute(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            return new ResponseEntity<>(e.exceptionErrorMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateProduct(ProductRequest productRequest, String productId) {
        try {
            updateProductUseCase.execute(productRequest, productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            if (e.getMessage().equals("Product_not_found"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @ResponseBody
    public ResponseEntity<?> getProducts() {
        try {
            List<Product> products = getProductsUseCase.execute();
            ProductListResponse productListResponse = Translator.translate(products, ProductListResponse.class);
            return new ResponseEntity<>(productListResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

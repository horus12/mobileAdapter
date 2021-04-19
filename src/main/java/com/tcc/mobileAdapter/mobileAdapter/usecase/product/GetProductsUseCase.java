package com.tcc.mobileAdapter.mobileAdapter.usecase.product;

import com.tcc.mobileAdapter.mobileAdapter.data.product.ProductMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GetProductsUseCase {

    private final ProductMongoRepository productRepository;

    public List<Product> execute() throws Exception {

        List<Product> productList = productRepository.findAll();
        if (!productList.isEmpty()) {
            return productList;
        } else
            return Collections.emptyList();
    }
}
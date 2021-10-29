package com.tcc.mobileAdapter.mobileAdapter.usecase.product;

import com.tcc.mobileAdapter.mobileAdapter.data.product.ProductMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetProductUseCase {

    private final ProductMongoRepository productRepository;

    public Product execute(String id) {

        Optional<Product> productList = productRepository.findById(id);
        return productList.orElse(null);
    }
}

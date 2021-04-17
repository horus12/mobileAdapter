package com.tcc.mobileAdapter.mobileAdapter.usecase.product;

import com.tcc.mobileAdapter.mobileAdapter.data.product.ProductMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteProductUseCase {

    private final ProductMongoRepository productRepository;

    public void execute(String productId) throws Exception {

        if (productRepository.findById(productId).isPresent()) {
            productRepository.deleteById(productId);
        } else throw new ProductNotFoundException("Product_not_found");
    }
}
package com.tcc.mobileAdapter.mobileAdapter.usecase.product;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.ProductRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.product.ProductMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import com.tcc.mobileAdapter.mobileAdapter.exception.AlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateProductUseCase {

    private final ProductMongoRepository productRepository;

    public Product execute(ProductRequest request) throws Exception {

        if (productRepository.findByName(request.getName()) != null) {
            throw new AlreadyExistException("Product_already_exists");
        }

        Product product = Product.builder().name(request.getName())
                .defaultImage(request.getDefaultImage())
                .description(request.getDescription())
                .enabled(request.getEnabled())
                .images(request.getImages())
                .type(request.getType())
                .category(request.getCategory())
                .build();
        productRepository.save(product);

        return product;
    }
}

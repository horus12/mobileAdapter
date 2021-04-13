package com.tcc.mobileAdapter.mobileAdapter.usecase;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CreateProductRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.product.ProductRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import com.tcc.mobileAdapter.mobileAdapter.exception.AlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateProductUseCase {

    private final ProductRepository productRepository;

    public Product execute(CreateProductRequest request) throws AlreadyExistException {

        if (productRepository.findByName(request.getName()) != null) {
            throw new AlreadyExistException("Product_already_exists");
        }

        Product product = Product.builder().name(request.getName())
                .defaultImage(request.getDefaultImage())
                .description(request.getDescription())
                .enabled(request.getEnabled())
                .images(request.getImages())
                .type(request.getType())
                .build();
        productRepository.save(product);

        return product;
    }
}

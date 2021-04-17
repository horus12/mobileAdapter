package com.tcc.mobileAdapter.mobileAdapter.usecase.product;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.ProductRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.product.ProductMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UpdateProductUseCase {

    private final ProductMongoRepository productRepository;

    public void execute(ProductRequest request, String productId) throws Exception {

        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            Product _product = product.get();
            _product.setName(request.getName());
            _product.setDefaultImage(request.getDefaultImage());
            _product.setDescription(request.getDescription());
            _product.setImages(request.getImages());
            _product.setEnabled(request.getEnabled());
            _product.setType(request.getType());

            productRepository.save(_product);
        } else {
            throw new Exception("Product_not_found");
        }
    }
}

package com.tcc.mobileAdapter.mobileAdapter.data.product;

import com.tcc.mobileAdapter.mobileAdapter.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(String id);

    Product findByName(String name);

    Product save(final Product product);
}

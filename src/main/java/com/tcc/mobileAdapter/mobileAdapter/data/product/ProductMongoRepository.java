package com.tcc.mobileAdapter.mobileAdapter.data.product;

import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductMongoRepository extends MongoRepository<Product, String> {
    Optional<Product> findById(String id);

    Product findByName(String name);

    Product save(final Product product);
}

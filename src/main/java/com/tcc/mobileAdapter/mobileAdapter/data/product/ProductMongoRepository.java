package com.tcc.mobileAdapter.mobileAdapter.data.product;

import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepository extends MongoRepository<Product, String>, ProductRepository {
}

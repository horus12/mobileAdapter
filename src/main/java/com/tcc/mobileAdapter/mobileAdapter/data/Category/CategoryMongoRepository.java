package com.tcc.mobileAdapter.mobileAdapter.data.Category;

import com.tcc.mobileAdapter.mobileAdapter.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryMongoRepository extends MongoRepository<Category, String> {
}

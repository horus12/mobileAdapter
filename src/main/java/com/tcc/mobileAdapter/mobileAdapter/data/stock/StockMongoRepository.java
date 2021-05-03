package com.tcc.mobileAdapter.mobileAdapter.data.stock;

import com.tcc.mobileAdapter.mobileAdapter.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockMongoRepository extends MongoRepository<Stock, String> {
}

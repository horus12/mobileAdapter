package com.tcc.mobileAdapter.mobileAdapter.data.stock;

import com.tcc.mobileAdapter.mobileAdapter.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockMongoRepository extends MongoRepository<Stock, String> {

    List<Stock> findByProductOrderByCreatedDateAsc(String product);
}

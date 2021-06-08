package com.tcc.mobileAdapter.mobileAdapter.usecase.stock;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.StockResponse;
import com.tcc.mobileAdapter.mobileAdapter.data.product.ProductMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.data.stock.StockMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import com.tcc.mobileAdapter.mobileAdapter.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetStockUseCase {
    private final StockMongoRepository stockMongoRepository;
    private final ProductMongoRepository productMongoRepository;

    public List<StockResponse> execute() {
        List<Stock> stockList = stockMongoRepository.findAll();
        List<StockResponse> response = new ArrayList<>();
        stockList.forEach(item -> {
            Optional<Product> product = productMongoRepository.findById(item.getProduct());
            product.ifPresent(value -> response.add(StockResponse.builder()
                    .product(value)
                    .price(item.getPrice())
                    .createdDate(item.getCreatedDate())
                    .quantity(item.getQuantity())
                    .id(item.getId())
                    .dueDate(item.getDueDate())
                    .build()));
        });
        return response;
    }
}

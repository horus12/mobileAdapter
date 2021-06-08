package com.tcc.mobileAdapter.mobileAdapter.usecase.stock;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.StockRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.product.ProductMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.data.stock.StockMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import com.tcc.mobileAdapter.mobileAdapter.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CreateStockUseCase {

    private final StockMongoRepository stockMongoRepository;
    private final ProductMongoRepository productRepository;

    public void execute(StockRequest request) throws Exception {

        Optional<Product> product = productRepository.findById(request.getProductId());

        if (product.isEmpty())
            throw new Exception("product_not_found");

        if (request.getQuantity() <= 0)
            throw new Exception("invalid_quantity");

        Stock stock = Stock.builder().product(product.get().getId())
                .quantity(request.getQuantity())
                .createdDate(LocalDate.now())
                .dueDate(request.getDueDate())
                .price(request.getPrice())
                .build();
        stockMongoRepository.save(stock);
    }
}

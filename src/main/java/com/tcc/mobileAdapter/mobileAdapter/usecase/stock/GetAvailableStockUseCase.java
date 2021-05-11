package com.tcc.mobileAdapter.mobileAdapter.usecase.stock;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AvailableProductsResponse;
import com.tcc.mobileAdapter.mobileAdapter.data.stock.StockMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetAvailableStockUseCase {
    private final StockMongoRepository stockMongoRepository;

    public List<AvailableProductsResponse> execute() {
        List<Stock> stockList = stockMongoRepository.findAll();
        List<AvailableProductsResponse> availableProducts = new ArrayList<>();

        stockList.forEach(item -> {
            AvailableProductsResponse a = new AvailableProductsResponse(item.getProduct(), item.getQuantity(), item.getPrice());
            availableProducts.add(a);
        });

        return availableProducts.stream()
                .collect(Collectors.collectingAndThen(Collectors.toMap(
                        AvailableProductsResponse::getProductId,
                        AvailableProductsResponse::new,
                        AvailableProductsResponse::merge), m -> new ArrayList<>(m.values())));
    }
}

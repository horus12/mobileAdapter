package com.tcc.mobileAdapter.mobileAdapter.usecase.stock;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.response.AvailableProductsResponse;
import com.tcc.mobileAdapter.mobileAdapter.data.product.ProductMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.data.stock.StockMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Product;
import com.tcc.mobileAdapter.mobileAdapter.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetAvailableStockUseCase {
    private final StockMongoRepository stockMongoRepository;
    private final ProductMongoRepository productMongoRepository;

    public List<AvailableProductsResponse> execute() {
        List<Stock> stockList = stockMongoRepository.findAll();
        List<AvailableProductsResponse> availableProducts = new ArrayList<>();

        stockList.forEach(item -> {
            Optional<Product> product = productMongoRepository.findById(item.getProduct());
            if (product.isPresent()) {
                AvailableProductsResponse a = new AvailableProductsResponse(
                        product.get(),
                        item.getQuantity(),
                        item.getPrice());
                availableProducts.add(a);
            }
        });

        List<AvailableProductsResponse> avlPrd = availableProducts.stream()
                .collect(Collectors.collectingAndThen(Collectors.toMap(
                        AvailableProductsResponse::getProductId,
                        AvailableProductsResponse::new,
                        AvailableProductsResponse::merge), m -> new ArrayList<>(m.values())));

        return avlPrd.stream()
                .sorted(Comparator.comparing(object -> object.getProduct().getName())).collect(Collectors.toList());
    }
}

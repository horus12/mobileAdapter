package com.tcc.mobileAdapter.mobileAdapter.usecase.stock;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.StockRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.stock.StockMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UpdateStockUseCase {
    private final StockMongoRepository stockMongoRepository;

    public void execute(StockRequest request, String StockId) throws Exception {
        Optional<Stock> stock = stockMongoRepository.findById(StockId);

        if (stock.isEmpty())
            throw new Exception("stock_not_found");

        if (request.getQuantity() <= 0)
            throw new Exception("invalid_quantity");

        Stock _stock = stock.get();
        _stock.setDueDate(request.getDueDate());
        _stock.setPrice(request.getPrice());
        _stock.setQuantity(request.getQuantity());
        stockMongoRepository.save(_stock);
    }
}

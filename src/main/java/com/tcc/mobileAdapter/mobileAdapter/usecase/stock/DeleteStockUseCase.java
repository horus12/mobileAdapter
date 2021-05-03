package com.tcc.mobileAdapter.mobileAdapter.usecase.stock;

import com.tcc.mobileAdapter.mobileAdapter.data.stock.StockMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteStockUseCase {
    private final StockMongoRepository stockMongoRepository;

    public void execute(String stockId) throws Exception {

        if (stockMongoRepository.findById(stockId).isEmpty())
            throw new Exception("stock_not_found");
        stockMongoRepository.deleteById(stockId);
    }
}

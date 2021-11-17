package com.tcc.mobileAdapter.mobileAdapter.usecase.stock;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.RemoveStockItemRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.RemoveStockRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.stock.StockMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@RequiredArgsConstructor
@Service
public class RemoveStockUseCase {
    private final StockMongoRepository stockMongoRepository;

    public void execute(RemoveStockRequest request) throws Exception {

        List<RemoveStockItemRequest> refusedList = new java.util.ArrayList<>(Collections.emptyList());

        for (int i = 0; i < request.getItems().size(); i++) {
            List<Stock> stockList = stockMongoRepository.findByProductOrderByCreatedDateAsc(request.getItems().get(i).getId());
            if (stockList.isEmpty()) refusedList.add(request.getItems().get(i));
            else {
                if (stockList.get(0).getQuantity() > request.getItems().get(i).getQuantity()) {
                    stockList.get(0).setQuantity(stockList.get(0).getQuantity() - request.getItems().get(i).getQuantity());
                    stockMongoRepository.save(stockList.get(0));
                } else if (stockList.get(0).getQuantity() == request.getItems().get(i).getQuantity()) {
                    stockMongoRepository.delete(stockList.get(0));
                } else {
                    removeFromOther(stockList, request.getItems().get(i).getQuantity());
                }
            }
        }
    }

    private void removeFromOther(List<Stock> stockList, int quantity) {
        int control = quantity;
        for (Stock stock : stockList) {

            if (control >= stock.getQuantity()) {
                control = control - stock.getQuantity();
                stockMongoRepository.delete(stock);
                if (control == 0) break;
            } else {
                stock.setQuantity(stock.getQuantity() - control);
                stockMongoRepository.save(stock);
                break;
            }
        }
    }
}
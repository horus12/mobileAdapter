package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.StockApi;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.RemoveStockRequest;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.StockRequest;
import com.tcc.mobileAdapter.mobileAdapter.usecase.stock.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@CrossOrigin
@RequiredArgsConstructor
public class StockController implements StockApi {

    private final CreateStockUseCase createStockUseCase;
    private final DeleteStockUseCase deleteStockUseCase;
    private final UpdateStockUseCase updateStockUseCase;
    private final GetStockUseCase getStockUseCase;
    private final RemoveStockUseCase removeStockUseCase;

    @Override
    public ResponseEntity<?> createStock(StockRequest stockRequest) {
        try {
            createStockUseCase.execute(stockRequest);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            if (e.getMessage().equals("product_not_found"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

            if (e.getMessage().equals("invalid_quantity"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteStock(String stockId) {
        try {
            deleteStockUseCase.execute(stockId);
        } catch (Exception e) {
            if (e.getMessage().equals("stock_not_found"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateStock(StockRequest stockRequest, String stockId) {
        try {
            updateStockUseCase.execute(stockRequest, stockId);
        } catch (Exception e) {
            if (e.getMessage().equals("stock_not_found"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

            if (e.getMessage().equals("invalid_quantity"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getStock() {

        return new ResponseEntity<>(getStockUseCase.execute(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateStock(RemoveStockRequest removeStockRequest) {
        try {
            removeStockUseCase.execute(removeStockRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

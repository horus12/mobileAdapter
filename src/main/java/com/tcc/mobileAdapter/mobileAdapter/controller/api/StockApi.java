package com.tcc.mobileAdapter.mobileAdapter.controller.api;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.StockRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping(path = "/stock")
public interface StockApi {

    @PostMapping("/createStock")
    ResponseEntity<?> createStock(@RequestBody StockRequest stockRequest);

    @DeleteMapping("/deleteStock/{stockId}")
    ResponseEntity<?> deleteStock(@PathVariable String stockId);

    @PutMapping("/updateStock/{stockId}")
    ResponseEntity<?> updateStock(@RequestBody StockRequest stockRequest, @PathVariable String stockId);

    @GetMapping
    ResponseEntity<?> getStock();

}

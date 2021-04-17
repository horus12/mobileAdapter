package com.tcc.mobileAdapter.mobileAdapter.controller.api;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/product")
public interface ProductApi {

    @PostMapping("/createProduct")
    ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest);

    @DeleteMapping("/deleteProduct/{productId}")
    ResponseEntity<?> deleteProduct(@PathVariable String productId);

    @PutMapping("/updateProduct/{productId}")
    ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest,@PathVariable String productId);

}
package com.tcc.mobileAdapter.mobileAdapter.controller.api;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.ProductRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping(path ="/product", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ProductApi {

    @PostMapping("/createProduct")
    ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest);

    @DeleteMapping("/deleteProduct/{productId}")
    ResponseEntity<?> deleteProduct(@PathVariable String productId);

    @PutMapping("/updateProduct/{productId}")
    ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest,@PathVariable String productId);

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getProducts();

}
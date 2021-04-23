package com.tcc.mobileAdapter.mobileAdapter.controller.api;


import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/category")
public interface CategoryApi {

    @GetMapping
    ResponseEntity<?> getCategory();


    @PostMapping("/createCategory")
    ResponseEntity<?> createCategory(@RequestBody CategoryRequest categoryRequest);
}

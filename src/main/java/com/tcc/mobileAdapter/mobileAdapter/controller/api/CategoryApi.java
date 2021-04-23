package com.tcc.mobileAdapter.mobileAdapter.controller.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@RequestMapping("/category")
public interface CategoryApi {

    @GetMapping
    ResponseEntity<?> getCategory();
}

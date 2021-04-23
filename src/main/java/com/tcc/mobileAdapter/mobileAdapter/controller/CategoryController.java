package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.CategoryApi;
import com.tcc.mobileAdapter.mobileAdapter.domain.Category;
import com.tcc.mobileAdapter.mobileAdapter.usecase.category.GetCategoryUseCase;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@CrossOrigin
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {

    private final GetCategoryUseCase getCategoryUseCase;

    @Override
    public ResponseEntity<?> getCategory() {
        List<Category> categoryList = getCategoryUseCase.execute();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}

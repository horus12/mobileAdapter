package com.tcc.mobileAdapter.mobileAdapter.controller;

import com.tcc.mobileAdapter.mobileAdapter.controller.api.CategoryApi;
import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CategoryRequest;
import com.tcc.mobileAdapter.mobileAdapter.domain.Category;
import com.tcc.mobileAdapter.mobileAdapter.usecase.category.CreateCategoryUseCase;
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
    private final CreateCategoryUseCase createCategoryUseCase;

    @Override
    public ResponseEntity<?> getCategory() {
        List<Category> categoryList = getCategoryUseCase.execute();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createCategory(CategoryRequest categoryRequest){
        Category category;
        try {
            category = createCategoryUseCase.execute(categoryRequest);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            if (e.getMessage().equals("Category_already_exists"))
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            else
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (category != null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

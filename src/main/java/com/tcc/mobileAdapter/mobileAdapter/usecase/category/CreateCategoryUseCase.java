package com.tcc.mobileAdapter.mobileAdapter.usecase.category;

import com.tcc.mobileAdapter.mobileAdapter.controller.domain.request.CategoryRequest;
import com.tcc.mobileAdapter.mobileAdapter.data.Category.CategoryMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Category;
import com.tcc.mobileAdapter.mobileAdapter.exception.AlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCategoryUseCase {

    private final CategoryMongoRepository categoryMongoRepository;

    public Category execute(CategoryRequest request) throws Exception{

        if(categoryMongoRepository.findByCategory(request.getCategory() )!= null){
            throw new AlreadyExistException("Category_already_exists");
        }

        Category category = Category.builder().category(request.getCategory())
                .enabled(request.getEnabled())
                .build();
        categoryMongoRepository.save(category);

        return category;
    }
}

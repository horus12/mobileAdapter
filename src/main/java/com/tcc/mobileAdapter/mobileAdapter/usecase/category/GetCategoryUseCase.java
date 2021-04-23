package com.tcc.mobileAdapter.mobileAdapter.usecase.category;

import com.tcc.mobileAdapter.mobileAdapter.data.Category.CategoryMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetCategoryUseCase {

    private final CategoryMongoRepository categoryMongoRepository;

    public List<Category> execute(){

        return categoryMongoRepository.findAll();
    }
}

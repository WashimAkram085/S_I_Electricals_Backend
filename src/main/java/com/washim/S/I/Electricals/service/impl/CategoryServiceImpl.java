package com.washim.S.I.Electricals.service.impl;

import com.washim.S.I.Electricals.dto.CategoryDto;
import com.washim.S.I.Electricals.dto.Response;
import com.washim.S.I.Electricals.entity.Category;
import com.washim.S.I.Electricals.exception.NotFoundException;
import com.washim.S.I.Electricals.mapper.EntityDtoMapper;
import com.washim.S.I.Electricals.repository.CategoryRepo;
import com.washim.S.I.Electricals.service.interf.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final EntityDtoMapper entityDtoMapper;

    @Override
    public Response createCategory(CategoryDto categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryRepo.save(category);
        return Response.builder()
                .message("Category created successfully")
                .status(200)
                .build();
    }

    @Override
    public Response updateCategory(Long categoryId, CategoryDto categoryRequest) {
       Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new NotFoundException("Category not found"));
       category.setName(categoryRequest.getName());
         categoryRepo.save(category);
        return Response.builder()
                .message("Category updated successfully")
                .status(200)
                .build();
    }

    @Override
    public Response getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> categoryDtoList = categories.stream().map(entityDtoMapper::mapCategoryToDtoBasic).collect(Collectors.toList());
        return Response.builder()
                .message("All categories fetched successfully")
                .status(200)
                .categoryList(categoryDtoList)
                .build();
    }

    @Override
    public Response getCategoryById(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new NotFoundException("Category not found"));
        CategoryDto categoryDto = entityDtoMapper.mapCategoryToDtoBasic(category);
        return Response.builder()
                .message("Category fetched successfully")
                .status(200)
                .category(categoryDto)
                .build();
    }

    @Override
    public Response deleteCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new NotFoundException("Category not found"));
        categoryRepo.delete(category);
        return Response.builder()
                .message("Category deleted successfully")
                .status(200)
                .build();
    }
}

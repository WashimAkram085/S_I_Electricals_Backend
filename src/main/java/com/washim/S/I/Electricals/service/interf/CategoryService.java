package com.washim.S.I.Electricals.service.interf;

import com.washim.S.I.Electricals.dto.CategoryDto;
import com.washim.S.I.Electricals.dto.Response;

public interface CategoryService {
    Response createCategory(CategoryDto categoryRequest);
    Response updateCategory(Long categoryId, CategoryDto categoryRequest);
    Response getAllCategories();
    Response getCategoryById(Long categoryId);
    Response deleteCategory(Long categoryId);
}

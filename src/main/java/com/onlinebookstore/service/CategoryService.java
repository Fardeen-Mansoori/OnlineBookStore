package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.dto.Category;
import com.onlinebookstore.exception.CategoryException;

public interface CategoryService {

	
	Category createCategory(Category category) throws CategoryException;
	Category getCategoryByCategoryId(Integer categoryId) throws CategoryException;
	Category updateCategory(Category category) throws CategoryException;
	String deleteCategoryById(Integer categoryId) throws CategoryException;
	List<Category> getAllCategory() throws CategoryException;
}

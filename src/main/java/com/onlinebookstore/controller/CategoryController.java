package com.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.Category;
import com.onlinebookstore.exception.CategoryException;
import com.onlinebookstore.service.CategoryService;
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("category/add")
	public Category addCategory(@RequestBody Category category) throws CategoryException {
		Category foundCategory = null;
		try {
			foundCategory = this.categoryService.createCategory(category);
		} catch (CategoryException e) {
			System.out.println(e.getMessage());
		}
		return foundCategory;
		
	}

	@GetMapping("category/get/{categoryId}")
	public Category getCategory(@PathVariable Integer categoryId) throws CategoryException {
		return this.categoryService.getCategoryByCategoryId(categoryId);

	}

	@PutMapping("category/update")
	public Category updateCategory(@RequestBody Category category) throws CategoryException {
		return this.categoryService.updateCategory(category);
		
	}

	@DeleteMapping("category/delete/{categoryId}")
	public String deleteCategoryById(@PathVariable Integer categoryId) throws CategoryException {
		return this.categoryService.deleteCategoryById(categoryId);
		
	}

	@GetMapping("category/categories")
	public List<Category> getAllCategories() throws CategoryException{
		return this.categoryService.getAllCategory();
	}
}

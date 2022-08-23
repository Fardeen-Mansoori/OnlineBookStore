package com.onlinebookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dao.CategoryRepository;
import com.onlinebookstore.dto.Category;
import com.onlinebookstore.exception.CategoryException;
import com.onlinebookstore.service.CategoryService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	Category category = new Category(101, "Science-Fiction", "Science");
	
	@Test
	public void createCategoryTest() throws CategoryException{
		assertNotNull(this.categoryService.createCategory(category));
		assertThrows(CategoryException.class,()->this.categoryService.createCategory(null));
		
	}
	@Test
	public void getCategoryByCategoryIdTest() throws CategoryException{
		assertNotNull(this.categoryService.createCategory(category));
		assertNotNull(this.categoryService.getCategoryByCategoryId(category.getCategoryId()));
		assertThrows(CategoryException.class,()->this.categoryService.getCategoryByCategoryId(0));
		assertThrows(CategoryException.class,()->this.categoryService.getCategoryByCategoryId(null));
	}
	@Test
	public void updateCategoryTest() throws CategoryException{
		assertNotNull(this.categoryService.createCategory(category));
		category.setCategoryName("Novels");
		assertNotNull(this.categoryService.updateCategory(category));
		assertEquals("Novels",category.getCategoryName());
		assertThrows(CategoryException.class,()->this.categoryService.updateCategory(null));
		
	}
	@Test
	public void deleteCategoryByIdTest() throws CategoryException{
		assertNotNull(this.categoryService.createCategory(category));
		assertEquals("Successful",this.categoryService.deleteCategoryById(category.getCategoryId()));
		assertThrows(CategoryException.class,()->this.categoryService.deleteCategoryById(0));
		assertThrows(CategoryException.class,()->this.categoryService.deleteCategoryById(null));
		
	}
	@Test
	public void getAllCategoryTest() throws CategoryException {
		assertNotNull(this.categoryService.createCategory(category));
		assertNotNull(this.categoryService.getAllCategory());
		
		
	}

}

package com.onlinebookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.CategoryRepository;
import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.Category;
import com.onlinebookstore.exception.CategoryException;
import com.onlinebookstore.exception.UserException;
/************************************************************************************
 * @author Rahul Likhar @Description It is a service class that provides
 *         the services for creating a new Category, get Category by ID, Update Category and
 *         Get All Categories. Version 1.0 Created Date 16-AUG-2022
 ************************************************************************************/
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	/************************************************************************************
	 * Method: - Add Category 
	 * Description: - Registered Category in the Book Store Application.
	 * 
	 * @object Category - Category detail
	 * @returns Boolean - true, if Category registered otherwise throws Category
	 *          Exception
	 * @throws UserException - It is raised due to Category details are invalid, or Category
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	public Category createCategory(Category category) throws CategoryException {
		if(category == null) {
			throw new CategoryException("Category cannot be Null!");
		}
		Category categoryAdded;
		try {
			categoryAdded = this.categoryRepository.save(category);
		} catch (Exception e) {
			throw new CategoryException("Category could not be Added!");
		}
		return categoryAdded;
	}
	/************************************************************************************
	 * Method: - Get Category By ID
	 * Description: - Get Registered Category by ID from the Book Store
	 * Application.
	 * 
	 * @object CategoryId - Category ID
	 * @returns Boolean - true, if Category registered otherwise throws Category
	 *          Exception
	 * @throws UserException - It is raised due to Category details are invalid, or Category
	 *                         id is not present.
	 ************************************************************************************/


	@Override
	public Category getCategoryByCategoryId(Integer categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		if(categoryId==null) {
			throw new CategoryException("Enter valid Category Id!");
		}
		Optional<Category> foundCategory = this.categoryRepository.findById(categoryId);
		if (foundCategory.isEmpty()) {
			throw new CategoryException("Category doesn't exists for categoryid " + categoryId);
		}
		return foundCategory.get();
	}
	/************************************************************************************
	 * Method: - Update Category 
	 * Description: - Updates Category in the Book Store Application.
	 * 
	 * @object Category - Update Category
	 * @returns Boolean - true, if Category registered otherwise throws Category
	 *          Exception
	 * @throws UserException - It is raised due to Category not present, or Category
	 *                       id is not present.
	 ************************************************************************************/
	@Override
	public Category updateCategory(Category category) throws CategoryException {
		// TODO Auto-generated method stub
		if(category == null) {
			throw new CategoryException("Category cannot be Null!");
		}
		Optional<Category> foundCategory = this.categoryRepository.findById(category.getCategoryId());

		if (foundCategory.isEmpty()) {
			throw new CategoryException("Category doesnot exists for id " + category.getCategoryId());
		}
		return this.categoryRepository.save(category);
	}
	/************************************************************************************
	 * Method: - Delete Category 
	 * Description: - Delete Category in the Book Store Application.
	 * 
	 * @object Category - Category Removal
	 * @returns Boolean - true, if Category registered otherwise throws Category
	 *          Exception
	 * @throws UserException - It is raised due to Category details are invalid, or Category
	 *                       id is not present.
	 ************************************************************************************/
	@Override
	public String deleteCategoryById(Integer categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		if(categoryId == null) {
			throw new CategoryException("Enter valid Category Id!");
		}
		String isDeleted;
		Optional<Category> foundCategory = categoryRepository.findById(categoryId);
		if (foundCategory.isEmpty()) {
			throw new CategoryException("Category does not exist for id " + categoryId);
		}else {
			categoryRepository.delete(foundCategory.get());
			isDeleted = "Successful";
		}
		return isDeleted;

	}
	/************************************************************************************
	 * Method: - get all Category 
	 * Description: - Get all Category in the Book Store Application.
	 * 
	 * @object Category - get all Categories
	 * @returns Boolean - true, if Category registered otherwise throws Category
	 *          Exception
	 * @throws UserException - It is raised due to Category details are invalid, or Category
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	public List<Category> getAllCategory() throws CategoryException {
		// TODO Auto-generated method stub
		List<Category> categoryList = this.categoryRepository.findAll();
		if(categoryList.isEmpty()) {
			throw new CategoryException("No Category Found");
		}
		return this.categoryRepository.findAll();
	}
	/************************************************************************************
	 * Method: - Find by Category 
	 * Description: - Find by Category in the Book Store Application.
	 * 
	 * @object Category - Find Category
	 * @returns Boolean - true, if Book registered in category otherwise throws Category
	 *          Exception
	 * @throws UserException - It is raised due to books are not present, or Book
	 *                       id is not present.
	 ************************************************************************************/
	@Override
	public List<Book> findBycategoryName(String categoryName) throws CategoryException {
		// TODO Auto-generated method stub
		
		Category  category = categoryRepository.findBycategoryName(categoryName);
		if(category.getBook().isEmpty()) {
			throw new CategoryException("No books found");
		}
		return category.getBook();
	}
}

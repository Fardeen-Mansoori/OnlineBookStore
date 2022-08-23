package com.onlinebookstore.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.dto.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	

	Category findBycategoryName(String categoryName);

}

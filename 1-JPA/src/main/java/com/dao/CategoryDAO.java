package com.dao;

import java.util.List;

import com.entity.Category;
import com.vo.CategoryVO;

public interface CategoryDAO {
	public void insertCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Integer categoryId);

	public List<CategoryVO> getCategories();
}

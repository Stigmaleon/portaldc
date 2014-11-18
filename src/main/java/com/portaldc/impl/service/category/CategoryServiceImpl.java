package com.portaldc.impl.service.category;

import java.util.List;

import com.portaldc.api.model.category.Category;
import com.portaldc.api.model.category.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portaldc.api.dao.category.CategoryDAO;
import com.portaldc.api.dto.category.CategoryDTO;
import com.portaldc.api.service.category.CategoryService;
import com.portaldc.impl.dto.category.CategoryDTOFactory;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDAO categoryDAO;
	
	CategoryDTOFactory categoryFactory = new CategoryDTOFactory();
	
	@Override
	@Transactional
	public List<CategoryDTO> getCategoriesDTO() {
		List<Category> categories = categoryDAO.getCategories();
		return categoryFactory.createDTOs(categories);
	}

}

package com.portaldc.impl.dto.category;

import java.util.ArrayList;
import java.util.List;

import com.portaldc.api.dto.category.CategoryDTO;
import com.portaldc.api.model.category.Category;

public class CategoryDTOFactory {
	
	public List<CategoryDTO> createDTOs(List<Category> categories){
		
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		
		if (categories != null) {			
			
			for (Category c : categories) {
				
				CategoryDTO categoryDTO = new CategoryDTO();
				categoryDTO.setId(c.getId());
				categoryDTO.setName(c.getName());
				
				categoryDTOs.add(categoryDTO);
			
			}			
			
		}
		
		return categoryDTOs;
	
	}

}

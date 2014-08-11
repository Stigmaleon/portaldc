package com.portaldc.web.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portaldc.api.dto.category.CategoryDTO;
import com.portaldc.api.service.category.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@Secured(value = "ROLE_USER")
	@RequestMapping(value = "/getCategories", 
					method = RequestMethod.GET, 
					headers = "Accept=application/json")
	public @ResponseBody List<CategoryDTO> getCategories(){
		return categoryService.getCategoriesDTO();
	}

}

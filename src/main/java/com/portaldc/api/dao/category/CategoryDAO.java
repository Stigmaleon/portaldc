package com.portaldc.api.dao.category;

import java.util.List;

import com.portaldc.api.model.category.Category;
import com.portaldc.api.model.category.Subcategory;

public interface CategoryDAO {

    public List<Category> getCategories();

}

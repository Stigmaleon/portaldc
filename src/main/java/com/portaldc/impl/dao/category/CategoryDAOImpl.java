package com.portaldc.impl.dao.category;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portaldc.api.dao.category.CategoryDAO;
import com.portaldc.api.model.category.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategoris() {		
		return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}

}

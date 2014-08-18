package com.portaldc.impl.dao.category;

import java.util.List;

import com.portaldc.api.model.category.Category;
import com.portaldc.api.model.category.Subcategory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portaldc.api.dao.category.CategoryDAO;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategoris() {
		return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).addOrder(Order.asc("id")).list();
	}

}

package com.portaldc.impl.dao.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.portaldc.api.dao.user.UserDAO;
import com.portaldc.api.model.user.User;

@Repository
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory	sessionFactory;
	
	@Override
	public void addUser(User user)
	{
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Override
	public User getUser(String login)
	{
		Query query = sessionFactory.getCurrentSession().getNamedQuery("currentUser");		
		query.setParameter("login", login);
		return (User) query.uniqueResult();
	}
}

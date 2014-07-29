package com.portaldc.impl.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.portaldc.api.dao.UserDAO;
import com.portaldc.api.model.User;

@Repository
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory	sessionFactory;
	
	@Override
	@Transactional
	public void addUser(User user)
	{
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Override
    @Transactional
	public User getUser(String login)
	{
		// TODO rewrite
		Query query = sessionFactory.getCurrentSession().getNamedQuery("currentUser").setString("login", login);
		List<User> users = query.list();
		User user = users.get(0);
		return user;
	}
}

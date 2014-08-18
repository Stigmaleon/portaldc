package com.portaldc.impl.dao.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
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
	public User findUserByLogin(String login)
	{
		Query query = sessionFactory.getCurrentSession().getNamedQuery("currentUser");		
		query.setParameter("login", login);
		return (User) query.uniqueResult();
	}

    @Override
    public User findUserById(Long id) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", Long.toString(id))).list().get(0);
    }
}

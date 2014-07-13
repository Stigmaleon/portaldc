package com.portaldc.impl.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.portaldc.api.dao.UserDAO;
import com.portaldc.impl.dao.UserDAOImpl;


public class SecurityServiceImpl implements UserDetailsService
{
	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		userDAO.getUser(username);
		System.out.println("TEST");
		return null;
	}
	
}

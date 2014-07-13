package com.portaldc.api.dao;

import com.portaldc.api.model.User;

public interface UserDAO
{
	
	public void addUser(User user);
	
	public User getUser(String login);
	
}

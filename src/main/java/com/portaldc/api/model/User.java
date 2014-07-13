package com.portaldc.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({ 
	@NamedQuery(
			name = "currentUser", 
			query = "from User u where u.login = :login") 
	})
public class User extends Identificator
{
	
	@Column(name = "login")
	private String	login;
	@Column(name = "password")
	private String	password;
	
	public String getLogin()
	{
		return login;
	}
	
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
}

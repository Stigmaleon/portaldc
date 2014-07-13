package com.portaldc.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Identificator implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private long	id;
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
}

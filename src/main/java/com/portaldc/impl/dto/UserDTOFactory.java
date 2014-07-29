package com.portaldc.impl.dto;

import com.portaldc.api.dto.UserDTO;
import com.portaldc.api.model.User;


public class UserDTOFactory
{
	
	public UserDTO createDTO(User user)
	{
		
		UserDTO dto = new UserDTO();
		dto.setLogin(user.getLogin());
		dto.setPassword(user.getPassword());
		
		return dto;
		
	}
	
	public User createModel(UserDTO dto)
	{
		
		User model = new User();
		model.setLogin(dto.getLogin());
		model.setPassword(dto.getPassword());
		
		return model;
		
	}
	
}

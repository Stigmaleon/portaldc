package com.portaldc.impl.dto.user;

import com.portaldc.api.dto.user.UserDTO;
import com.portaldc.api.model.user.User;


public class UserDTOFactory
{
	
	public UserDTO createDTO(User user)
	{
		
		UserDTO dto = new UserDTO();
		dto.setLogin(user.getLogin());
		dto.setPassword(user.getPassword());
		dto.setEmail(user.getEmail());
		
		return dto;
		
	}
	
	public User createModel(UserDTO dto)
	{
		
		User model = new User();
		model.setLogin(dto.getLogin());
		model.setPassword(dto.getPassword());
		model.setEmail(dto.getEmail());
		
		return model;
		
	}
	
}

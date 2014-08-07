package com.portaldc.api.service.user;

import com.portaldc.api.dto.user.UserDTO;

public interface UserService
{
	public UserDTO saveNewUser(UserDTO userDTO);
	public UserDTO getUser(String login);
}

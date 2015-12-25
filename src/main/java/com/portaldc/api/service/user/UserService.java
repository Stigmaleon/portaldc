package com.portaldc.api.service.user;

import com.portaldc.api.dto.user.UserDTO;

public interface UserService {
    UserDTO saveNewUser(UserDTO userDTO);

    UserDTO getUser(String login);

    UserDTO getUserById(Long userId);
}

package com.portaldc.impl.service.profile;

import com.portaldc.api.dto.profile.ProfileDTO;
import com.portaldc.api.dto.user.UserDTO;
import com.portaldc.api.service.profile.ProfileService;
import com.portaldc.api.service.user.UserService;
import com.portaldc.impl.dto.profile.ProfileDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileDTOFactory profileDTOFactory;

    @Override
    public ProfileDTO getUserProfile(Long userId) {

        UserDTO userDTO = userService.getUserById(userId);

        return profileDTOFactory.createDTO(userDTO);

    }
}

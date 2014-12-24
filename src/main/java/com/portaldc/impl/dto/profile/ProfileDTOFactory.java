package com.portaldc.impl.dto.profile;

import com.portaldc.api.data.UserRole;
import com.portaldc.api.dto.profile.ProfileDTO;
import com.portaldc.api.dto.user.UserDTO;
import com.portaldc.api.model.role.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileDTOFactory {

    public ProfileDTO createDTO(UserDTO userDTO) {
        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setLogin(userDTO.getLogin());
        profileDTO.setEmail(userDTO.getLogin());

        List<Role> roles = userDTO.getRoles();
        Boolean isAdmin = false;
        Boolean isModerator = false;
        Boolean isUser = false;
        for (Role role : roles) {

            isAdmin = role.getName().equals("ROLE_ADMIN");
            isModerator = role.getName().equals("ROLE_MODERATOR");
            isUser = role.getName().equals("ROLE_USER");

        }

        if (isAdmin)
            profileDTO.setRole(UserRole.ADMIN);
        else if (isModerator)
            profileDTO.setRole(UserRole.MODERATOR);
        else if (isUser)
            profileDTO.setRole(UserRole.USER);

        return profileDTO;
    }

}

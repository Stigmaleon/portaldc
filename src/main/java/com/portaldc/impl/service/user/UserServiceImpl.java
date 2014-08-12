package com.portaldc.impl.service.user;

import com.portaldc.api.dao.role.RoleDAO;
import com.portaldc.api.model.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portaldc.api.dao.user.UserDAO;
import com.portaldc.api.dto.user.UserDTO;
import com.portaldc.api.model.user.User;
import com.portaldc.api.service.user.UserService;
import com.portaldc.impl.dto.user.UserDTOFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

	UserDTOFactory userFactory = new UserDTOFactory();

	@Override
	@Transactional
	public UserDTO saveNewUser(UserDTO userDTO) {

        List<Role> roles = new ArrayList<Role>();
        List<Role> settingRoles = new ArrayList<Role>();
        Role settingRole = new Role();
        User user = new User();

        roles = roleDAO.getRoles();
		user = userFactory.createModel(userDTO);
		userDAO.addUser(user);
        for(Role r : roles){
            if(r.getName() .equals("ROLE_USER"))
                settingRole = r;
        }
        settingRoles.add(settingRole);
        user.setRoles(settingRoles);
		return userFactory.createDTO(user);
	}
	
	@Override
	@Transactional
	public UserDTO getUser(String login) {
		
		User user = userDAO.getUser(login);			
		return userFactory.createDTO(user);
	}

}

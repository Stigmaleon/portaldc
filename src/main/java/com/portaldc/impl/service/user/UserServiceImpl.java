package com.portaldc.impl.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portaldc.api.dao.user.UserDAO;
import com.portaldc.api.dto.user.UserDTO;
import com.portaldc.api.model.user.User;
import com.portaldc.api.service.user.UserService;
import com.portaldc.impl.dto.user.UserDTOFactory;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;

	UserDTOFactory userFactory = new UserDTOFactory();

	@Override
	@Transactional
	public UserDTO saveNewUser(UserDTO userDTO) {
		
		User user = new User();
		user = userFactory.createModel(userDTO);
		userDAO.addUser(user);
		return userFactory.createDTO(user);
	}
	
	@Override
	@Transactional
	public UserDTO getUser(String login) {
		
		User user = userDAO.getUser(login);			
		return userFactory.createDTO(user);
	}

}

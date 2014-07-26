package com.portaldc.impl.service.security;

import com.portaldc.api.dao.UserDAO;
import com.portaldc.api.model.User;
import com.portaldc.impl.dao.UserDAOImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements UserDetailsService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();

        user = userDAO.getUser(username);

        System.out.println("TEST");
        return user;
    }

}

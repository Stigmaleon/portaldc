package com.portaldc.impl.service.security;

import com.portaldc.api.dao.user.UserDAO;
import com.portaldc.api.model.role.Role;
import com.portaldc.api.model.security.SysUserDetails;
import com.portaldc.api.model.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = new User();

		user = userDAO.getUser(username);

		System.out.println("TEST");
		return prepareUser(user);
	}

	private UserDetails prepareUser(User user) {

		SysUserDetails userDetails = new SysUserDetails();
		userDetails.setUsername(user.getLogin());
		userDetails.setPassword(user.getPassword());
		for (Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(
					role.getName());
			userDetails.addAuthority(grantedAuthority);
		}
		return userDetails;
	}

}

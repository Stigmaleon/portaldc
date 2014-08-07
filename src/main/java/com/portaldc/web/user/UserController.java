package com.portaldc.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portaldc.api.dto.user.UserDTO;
import com.portaldc.api.service.user.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user/register",
			method = RequestMethod.POST,
			headers = "Accept=application/json")
	public @ResponseBody UserDTO saveNewUser(@RequestBody UserDTO userDTO){
		return userService.saveNewUser(userDTO);
	}
	
	@Secured(value = "ROLE_ADMIN")
	@RequestMapping(value = "/user/{login}",
			method = RequestMethod.GET,
			headers = "Accept=application/json")
	public @ResponseBody UserDTO getUser(@PathVariable("login") String login){
		return userService.getUser(login);
	}

}

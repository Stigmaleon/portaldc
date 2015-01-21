package com.portaldc.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.portaldc.api.dto.user.UserDTO;
import com.portaldc.api.service.user.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user/register",
			method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public void saveNewUser(@RequestBody UserDTO userDTO){
		userService.saveNewUser(userDTO);
	}
	
	@Secured(value = "ROLE_ADMIN")
	@RequestMapping(value = "/user/{login}",
			method = RequestMethod.GET,
			headers = "Accept=application/json")
	public @ResponseBody UserDTO getUser(@PathVariable("login") String login){
		return userService.getUser(login);
	}

}

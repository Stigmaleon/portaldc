package com.portaldc.web;

import com.portaldc.api.model.User;
import com.portaldc.impl.service.security.SecurityServiceImpl;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RedirectController{

    @RequestMapping(value = {"/", ""})
    public String index() throws Exception{
        return "redirect:/home";
    }
	
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
    	return "register";
    }

    
}

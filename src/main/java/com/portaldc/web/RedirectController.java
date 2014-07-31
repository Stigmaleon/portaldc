package com.portaldc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

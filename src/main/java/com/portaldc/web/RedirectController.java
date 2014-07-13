package com.portaldc.web;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RedirectController{
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(WebRequest webRequest, ModelMap modelMap){
		
		System.out.println(webRequest.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, WebRequest.SCOPE_SESSION));
		return null;
		
	}
	
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }
    
}

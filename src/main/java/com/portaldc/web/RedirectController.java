package com.portaldc.web;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portaldc.api.model.security.SysUserDetails;

@Controller
public class RedirectController{
	
	private static final String HOME_PAGE = "home";
	private static final String REGISTR_PAGE = "register";
	private static final String CREATE_DISTRIBUTION_PAGE = "createDistribution";

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(ModelMap modelMap) throws Exception{
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if(authentication.isAuthenticated()){
    		
    		SysUserDetails sysUserDetails = (SysUserDetails)authentication.getPrincipal();
    		Collection<GrantedAuthority> grantedAuthorities = (Collection<GrantedAuthority>) sysUserDetails.getAuthorities();
    		modelMap.addAttribute("user", sysUserDetails.getUsername());
    		
    		if(grantedAuthorities != null){
    			List<String> roleList = new LinkedList<String>();
    			Iterator<GrantedAuthority> grantedAuthorityIterator = grantedAuthorities.iterator();
    			
    			while(grantedAuthorityIterator.hasNext()){
    				roleList.add(grantedAuthorityIterator.next().getAuthority());
    			}
    			
    			if(roleList.contains("ROLE_ADMIN"))
    				return HOME_PAGE;
    			else if(roleList.contains("ROLE_USER"))
    				return HOME_PAGE;
    		}
    	}
    	
        return REGISTR_PAGE;
    }
	
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return HOME_PAGE;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
    	return REGISTR_PAGE;
    }
    
    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/create_distribution", method = RequestMethod.GET)
    public String createDistribution(){
    	return CREATE_DISTRIBUTION_PAGE;
    }
    
}

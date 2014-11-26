package com.portaldc.web;

import com.portaldc.api.model.security.SysUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {

    private static final String HOME_PAGE = "home";

    protected Long getUserId() {

        return getCurrentUser().getId();
    }

    protected SysUserDetails getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (SysUserDetails) authentication.getPrincipal();
    }

}

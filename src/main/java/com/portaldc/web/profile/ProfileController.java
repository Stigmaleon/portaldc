package com.portaldc.web.profile;

import com.portaldc.api.dto.profile.ProfileDTO;
import com.portaldc.api.service.profile.ProfileService;
import com.portaldc.web.AppController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController extends AppController{

    @Autowired
    ProfileService profileService;

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "get_user_profile", method = RequestMethod.GET)
    public @ResponseBody
    ProfileDTO getUSerProfile(){
        return profileService.getUserProfile(getUserId());
    }
}

package com.portaldc.web.distribution;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DistributionController {

    private static final String CREATE_DISTRIBUTION_FILM_PAGE = "createDistributionFilm";

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/create_distribution_film", method = RequestMethod.GET)
    public String createDistribution(){
        return CREATE_DISTRIBUTION_FILM_PAGE;
    }

}

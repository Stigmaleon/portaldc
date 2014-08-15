package com.portaldc.web.distribution.film;

import com.portaldc.api.data.DistributionState;
import com.portaldc.api.dto.distibution.film.FilmDTO;
import com.portaldc.web.AppController;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FilmDistributionController extends AppController{

    private static final String HOME_PAGE = "home";

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/createFilmDistribution",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json")
    public String createFilmDistribution(@RequestBody FilmDTO filmDTO){

        filmDTO.setState(DistributionState.NEW.getState());
        return HOME_PAGE;
    }

}

package com.portaldc.web.distribution.film;

import com.portaldc.api.data.DistributionState;
import com.portaldc.api.dto.distibution.film.FilmDTO;
import com.portaldc.api.service.distribution.film.FilmService;
import com.portaldc.web.AppController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest")
public class FilmDistributionController extends AppController{

    @Autowired
    FilmService filmService;

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/createFilmDistribution",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json")
    public @ResponseBody Long createFilmDistribution(@RequestBody FilmDTO filmDTO){

        filmDTO.setUser(getUserId());

        return filmService.saveFilm(filmDTO);
    }

}

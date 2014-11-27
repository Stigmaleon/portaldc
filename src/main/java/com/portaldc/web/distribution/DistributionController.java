package com.portaldc.web.distribution;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DistributionController {

    private static final String CREATE_DISTRIBUTION_FILM_PAGE = "createDistributionFilm";
    private static final String CREATE_DISTRIBUTION_AUDIO_PAGE = "createDistributionAudio";
    private static final String CREATE_DISTRIBUTIO_BOOK_PAGE = "createDistributionBook";

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/create_distribution_film", method = RequestMethod.GET)
    public String createFilmDistribution() {
        return CREATE_DISTRIBUTION_FILM_PAGE;
    }

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/create_distribution_audio", method = RequestMethod.GET)
    public String createAudioDistribution() {
        return CREATE_DISTRIBUTION_AUDIO_PAGE;
    }

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/create_distribution_book", method = RequestMethod.GET)
    public String createBookDistribution() {
        return CREATE_DISTRIBUTIO_BOOK_PAGE;
    }

}

package com.portaldc.impl.service.distribution.film;

import com.portaldc.api.dao.distribution.film.FilmDAO;
import com.portaldc.api.data.DistributionState;
import com.portaldc.api.dto.distibution.film.FilmDTO;
import com.portaldc.api.model.distributions.Film;
import com.portaldc.api.service.distribution.film.FilmService;
import com.portaldc.api.service.distribution.link.LinkService;
import com.portaldc.impl.dto.distribution.film.FilmDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmDAO filmDAO;

    @Autowired
    FilmDTOFactory filmDTOFactory;

    @Autowired
    LinkService linkService;

    @Override
    public Long saveFilm(FilmDTO filmDTO) {
        Long savedFilmId;
        Film film;

        if (filmDTO.getId() == null) {

            filmDTO.setState(DistributionState.NOT_MODERATED.getState());
            film = filmDTOFactory.createModel(filmDTO);
            savedFilmId = filmDAO.saveDistribution(film);
            film.setId(savedFilmId);

            linkService.saveLinks(filmDTO.getLinks(), film);

            return savedFilmId;
        } else
            return -1L;
    }
}

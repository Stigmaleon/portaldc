package com.portaldc.impl.dto.distribution.film;

import com.portaldc.api.dto.distibution.film.FilmDTO;
import com.portaldc.api.model.distributions.Film;

public class FilmDTOFactory {

    public Film createModel(FilmDTO dto){
        Film film = new Film();

        if(dto != null){
            film.setLinkImdb(dto.getLinkImdb());
            film.setLinkKinopoisk(dto.getLinkKinopoisk());
            film.setTime(dto.getTime());
            film.setCategories(dto.getCategories());
            film.setCountry(dto.getCountry());
            film.setDescription(dto.getDescription());
            film.setGanre(dto.getGanre());
            film.setId(dto.getId());
            film.setLinks(dto.getLinks());
            film.setName(dto.getName());
            film.setNativeName(dto.getNativeName());
            film.setGanre(dto.getGanre());
            film.setState(dto.getState());
            film.setYear(dto.getYear());
        }

        return film;
    }
}

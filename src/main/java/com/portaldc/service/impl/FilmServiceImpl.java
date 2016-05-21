package com.portaldc.service.impl;

import com.portaldc.service.FilmService;
import com.portaldc.domain.Film;
import com.portaldc.repository.FilmRepository;
import com.portaldc.web.rest.dto.FilmDTO;
import com.portaldc.web.rest.mapper.FilmMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Film.
 */
@Service
@Transactional
public class FilmServiceImpl implements FilmService{

    private final Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);
    
    @Inject
    private FilmRepository filmRepository;
    
    @Inject
    private FilmMapper filmMapper;
    
    /**
     * Save a film.
     * 
     * @param filmDTO the entity to save
     * @return the persisted entity
     */
    public FilmDTO save(FilmDTO filmDTO) {
        log.debug("Request to save Film : {}", filmDTO);
        Film film = filmMapper.filmDTOToFilm(filmDTO);
        film = filmRepository.save(film);
        FilmDTO result = filmMapper.filmToFilmDTO(film);
        return result;
    }

    /**
     *  Get all the films.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<Film> findAll(Pageable pageable) {
        log.debug("Request to get all Films");
        Page<Film> result = filmRepository.findAll(pageable); 
        return result;
    }

    /**
     *  Get one film by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public FilmDTO findOne(Long id) {
        log.debug("Request to get Film : {}", id);
        Film film = filmRepository.findOne(id);
        FilmDTO filmDTO = filmMapper.filmToFilmDTO(film);
        return filmDTO;
    }

    /**
     *  Delete the  film by id.
     *  
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Film : {}", id);
        filmRepository.delete(id);
    }
}

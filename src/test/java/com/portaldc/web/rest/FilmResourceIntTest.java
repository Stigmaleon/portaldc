package com.portaldc.web.rest;

import com.portaldc.PortaldcApp;
import com.portaldc.domain.Film;
import com.portaldc.repository.FilmRepository;
import com.portaldc.service.FilmService;
import com.portaldc.web.rest.dto.FilmDTO;
import com.portaldc.web.rest.mapper.FilmMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.hasItem;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Test class for the FilmResource REST controller.
 *
 * @see FilmResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PortaldcApp.class)
@WebAppConfiguration
@IntegrationTest
public class FilmResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAA";
    private static final String UPDATED_NAME = "BBBBB";

    private static final LocalDate DEFAULT_YEAR = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_YEAR = LocalDate.now(ZoneId.systemDefault());

    @Inject
    private FilmRepository filmRepository;

    @Inject
    private FilmMapper filmMapper;

    @Inject
    private FilmService filmService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restFilmMockMvc;

    private Film film;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        FilmResource filmResource = new FilmResource();
        ReflectionTestUtils.setField(filmResource, "filmService", filmService);
        ReflectionTestUtils.setField(filmResource, "filmMapper", filmMapper);
        this.restFilmMockMvc = MockMvcBuilders.standaloneSetup(filmResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        film = new Film();
        film.setName(DEFAULT_NAME);
        film.setYear(DEFAULT_YEAR);
    }

    @Test
    @Transactional
    public void createFilm() throws Exception {
        int databaseSizeBeforeCreate = filmRepository.findAll().size();

        // Create the Film
        FilmDTO filmDTO = filmMapper.filmToFilmDTO(film);

        restFilmMockMvc.perform(post("/api/films")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(filmDTO)))
                .andExpect(status().isCreated());

        // Validate the Film in the database
        List<Film> films = filmRepository.findAll();
        assertThat(films).hasSize(databaseSizeBeforeCreate + 1);
        Film testFilm = films.get(films.size() - 1);
        assertThat(testFilm.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testFilm.getYear()).isEqualTo(DEFAULT_YEAR);
    }

    @Test
    @Transactional
    public void getAllFilms() throws Exception {
        // Initialize the database
        filmRepository.saveAndFlush(film);

        // Get all the films
        restFilmMockMvc.perform(get("/api/films?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(film.getId().intValue())))
                .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
                .andExpect(jsonPath("$.[*].year").value(hasItem(DEFAULT_YEAR.toString())));
    }

    @Test
    @Transactional
    public void getFilm() throws Exception {
        // Initialize the database
        filmRepository.saveAndFlush(film);

        // Get the film
        restFilmMockMvc.perform(get("/api/films/{id}", film.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(film.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.year").value(DEFAULT_YEAR.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingFilm() throws Exception {
        // Get the film
        restFilmMockMvc.perform(get("/api/films/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFilm() throws Exception {
        // Initialize the database
        filmRepository.saveAndFlush(film);
        int databaseSizeBeforeUpdate = filmRepository.findAll().size();

        // Update the film
        Film updatedFilm = new Film();
        updatedFilm.setId(film.getId());
        updatedFilm.setName(UPDATED_NAME);
        updatedFilm.setYear(UPDATED_YEAR);
        FilmDTO filmDTO = filmMapper.filmToFilmDTO(updatedFilm);

        restFilmMockMvc.perform(put("/api/films")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(filmDTO)))
                .andExpect(status().isOk());

        // Validate the Film in the database
        List<Film> films = filmRepository.findAll();
        assertThat(films).hasSize(databaseSizeBeforeUpdate);
        Film testFilm = films.get(films.size() - 1);
        assertThat(testFilm.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testFilm.getYear()).isEqualTo(UPDATED_YEAR);
    }

    @Test
    @Transactional
    public void deleteFilm() throws Exception {
        // Initialize the database
        filmRepository.saveAndFlush(film);
        int databaseSizeBeforeDelete = filmRepository.findAll().size();

        // Get the film
        restFilmMockMvc.perform(delete("/api/films/{id}", film.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Film> films = filmRepository.findAll();
        assertThat(films).hasSize(databaseSizeBeforeDelete - 1);
    }
}

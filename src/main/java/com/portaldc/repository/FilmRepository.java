package com.portaldc.repository;

import com.portaldc.domain.Film;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Film entity.
 */
public interface FilmRepository extends JpaRepository<Film,Long> {

}

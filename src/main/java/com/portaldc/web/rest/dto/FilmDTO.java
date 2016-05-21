package com.portaldc.web.rest.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;


/**
 * A DTO for the Film entity.
 */
public class FilmDTO implements Serializable {

    private Long id;

    private String name;

    private LocalDate year;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FilmDTO filmDTO = (FilmDTO) o;

        if ( ! Objects.equals(id, filmDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "FilmDTO{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", year='" + year + "'" +
            '}';
    }
}

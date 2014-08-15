package com.portaldc.api.dto.distibution.film;

import com.portaldc.api.dto.distibution.DistributionDTO;

public class FilmDTO extends DistributionDTO {

    private String time;
    private String linkKinopoisk;
    private String linkImdb;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLinkKinopoisk() {
        return linkKinopoisk;
    }

    public void setLinkKinopoisk(String linkKinopoisk) {
        this.linkKinopoisk = linkKinopoisk;
    }

    public String getLinkImdb() {
        return linkImdb;
    }

    public void setLinkImdb(String linkImdb) {
        this.linkImdb = linkImdb;
    }
}

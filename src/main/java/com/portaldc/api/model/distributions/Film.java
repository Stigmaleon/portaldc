package com.portaldc.api.model.distributions;

import com.portaldc.api.model.links.Link;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dmitry Romaniuk on 10.08.2014.
 */

@Entity
@Table(name = "distribution")
@DiscriminatorValue(value = "film")
public class Film extends Distribution {

    @Column(name = "time")
    private String time;
    @Column(name = "link_kinopoisk")
    private String linkKinopoisk;
    @Column(name = "link_imdb")
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

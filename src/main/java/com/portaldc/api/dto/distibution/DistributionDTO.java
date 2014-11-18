package com.portaldc.api.dto.distibution;

import com.portaldc.api.dto.distibution.link.LinkDTO;
import com.portaldc.api.model.category.Subcategory;
import com.portaldc.api.model.distributions.link.Link;

import java.io.Serializable;
import java.util.List;

public class DistributionDTO implements Serializable {

    private Long id;
    private String name;
    private String nativeName;
    private int year;
    private String description;
    private String ganre;
    private String country;
    private String state;
    private List<LinkDTO> links;
    private List<Subcategory> categories;
    private Long user;

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

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGanre() {
        return ganre;
    }

    public void setGanre(String ganre) {
        this.ganre = ganre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<LinkDTO> getLinks() {
        return links;
    }

    public void setLinks(List<LinkDTO> links) {
        this.links = links;
    }

    public List<Subcategory> getCategories() {
        return categories;
    }

    public void setCategories(List<Subcategory> categories) {
        this.categories = categories;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}

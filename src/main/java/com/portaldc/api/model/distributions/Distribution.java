package com.portaldc.api.model.distributions;

import com.portaldc.api.model.Identificator;
import com.portaldc.api.model.category.Subcategory;
import com.portaldc.api.model.distributions.link.Link;
import com.portaldc.api.model.user.User;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "distribution")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "distribution")
public class Distribution extends Identificator {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "name_native")
    private String nativeName;
    @Column(name = "year")
    private int year;
    @Column(name = "description")
    private String description;
    @Column(name = "ganre")
    private String ganre;
    @Column(name = "country")
    private String country;
    @Column(name = "state", nullable = false)
    private String state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "distribution")
    private List<Link> links;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "distribution_to_subcategory",
            joinColumns = {@JoinColumn(name = "id_distribution")},
            inverseJoinColumns = {@JoinColumn(name = "id_subcategory")})
    private List<Subcategory> subcategories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

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

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> categories) {
        this.subcategories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

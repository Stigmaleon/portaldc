package com.portaldc.api.model.distributions;

import com.portaldc.api.model.Identificator;
import com.portaldc.api.model.category.Category;
import com.portaldc.api.model.links.Link;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry Romaniuk on 10.08.2014.
 */

@Entity
@Table(name = "distribution")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "distribution")
public class Distribution extends Identificator{

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "name_native")
    private  String nativeName;
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
    List<Link> links;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "distribution_to_category",
                joinColumns = {@JoinColumn(name = "id_distribution")},
                inverseJoinColumns = {@JoinColumn(name = "id_category")})
    private List<Category> categories;

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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

package com.portaldc.api.model.category;

import com.portaldc.api.model.Identificator;
import com.portaldc.api.model.distributions.Distribution;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dmitry Romaniuk on 10.08.2014.
 */

@Entity
@Table(name = "distribution_category")
public class Category extends Identificator {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Distribution> distributions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Distribution> getDistributions() {
        return distributions;
    }

    public void setDistributions(List<Distribution> distributions) {
        this.distributions = distributions;
    }
}

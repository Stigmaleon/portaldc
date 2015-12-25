package com.portaldc.api.model.category;

import com.portaldc.api.model.Identificator;
import com.portaldc.api.model.distributions.Distribution;
import com.portaldc.api.model.category.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "distribution_subcategory")
public class Subcategory extends Identificator {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subcategories")
    private List<Distribution> distributions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

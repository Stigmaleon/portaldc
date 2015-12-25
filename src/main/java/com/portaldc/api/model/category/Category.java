package com.portaldc.api.model.category;

import com.portaldc.api.model.Identificator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "distribution_category")
public class Category extends Identificator {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Subcategory> subcategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}

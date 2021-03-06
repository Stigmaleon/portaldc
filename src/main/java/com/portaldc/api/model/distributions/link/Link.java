package com.portaldc.api.model.distributions.link;

import com.portaldc.api.model.Identificator;
import com.portaldc.api.model.distributions.Distribution;

import javax.persistence.*;

@Entity
@Table(name = "links")
public class Link extends Identificator {

    @Column(name = "link_position", nullable = false)
    private int position;
    @Column(name = "link_name", nullable = false)
    private String name;
    @Column(name = "link_magnet", nullable = false)
    private String magnet;
    @Column(name = "link_size", nullable = false)
    private Long size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_distribution", nullable = false)
    private Distribution distribution;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMagnet() {
        return magnet;
    }

    public void setMagnet(String magnet) {
        this.magnet = magnet;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}

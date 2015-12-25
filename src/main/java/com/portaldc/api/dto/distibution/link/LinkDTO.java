package com.portaldc.api.dto.distibution.link;

import com.portaldc.api.model.distributions.Distribution;

import java.io.Serializable;

public class LinkDTO implements Serializable {

    private Integer position;
    private String name;
    private String magnet;
    private Long size;
    private Distribution distribution;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
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

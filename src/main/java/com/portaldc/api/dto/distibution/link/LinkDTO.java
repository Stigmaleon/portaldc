package com.portaldc.api.dto.distibution.link;

import com.portaldc.api.model.distributions.Distribution;

import java.io.Serializable;

public class LinkDTO implements Serializable {

    public Integer posision;
    private String name;
    private String magnet;
    private Distribution distribution;

    public Integer getPosision() {
        return posision;
    }

    public void setPosision(Integer posision) {
        this.posision = posision;
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
}

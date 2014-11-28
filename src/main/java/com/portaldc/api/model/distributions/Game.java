package com.portaldc.api.model.distributions;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "distribution")
@DiscriminatorValue(value = "game")
public class Game extends Distribution {

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "developer")
    private String developer;

    @Column(name = "publType")
    private String publicationType;

    @Column(name = "language")
    private String language;

    @Column(name = "translate")
    private String translate;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
}

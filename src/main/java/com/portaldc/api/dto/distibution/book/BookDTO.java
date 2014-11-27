package com.portaldc.api.dto.distibution.book;

import com.portaldc.api.dto.distibution.DistributionDTO;

public class BookDTO extends DistributionDTO {

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

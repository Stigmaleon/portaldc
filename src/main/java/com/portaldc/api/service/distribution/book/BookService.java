package com.portaldc.api.service.distribution.book;

import com.portaldc.api.dto.distibution.book.BookDTO;

public interface BookService {
    public Long saveBook(BookDTO bookDTO);
}

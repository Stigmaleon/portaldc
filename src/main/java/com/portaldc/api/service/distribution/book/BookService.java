package com.portaldc.api.service.distribution.book;

import com.portaldc.api.dto.distibution.book.BookDTO;

public interface BookService {
    Long saveBook(BookDTO bookDTO);
}

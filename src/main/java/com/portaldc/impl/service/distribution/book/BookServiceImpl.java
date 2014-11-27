package com.portaldc.impl.service.distribution.book;

import com.portaldc.api.dao.distribution.book.BookDAO;
import com.portaldc.api.data.DistributionState;
import com.portaldc.api.dto.distibution.book.BookDTO;
import com.portaldc.api.model.distributions.Book;
import com.portaldc.api.service.distribution.book.BookService;
import com.portaldc.api.service.distribution.link.LinkService;
import com.portaldc.impl.dto.distribution.book.BookDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDAO bookDAO;

    @Autowired
    BookDTOFactory bookDTOFactory;

    @Autowired
    LinkService linkService;

    @Override
    public Long saveBook(BookDTO bookDTO) {
        Long savedBookId;
        Book book;

        if (bookDTO.getId() == null) {
            bookDTO.setState(DistributionState.NOT_MODERATED.getState());
            book = bookDTOFactory.createModel(bookDTO);
            savedBookId = bookDAO.saveDistribution(book);
            book.setId(savedBookId);

            linkService.saveLinks(bookDTO.getLinks(), book);

            return savedBookId;
        } else
            return -1L;
    }
}

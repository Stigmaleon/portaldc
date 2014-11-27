package com.portaldc.impl.dto.distribution.book;

import com.portaldc.api.dao.user.UserDAO;
import com.portaldc.api.dto.distibution.book.BookDTO;
import com.portaldc.api.model.distributions.Book;
import com.portaldc.impl.dto.distribution.link.LinkDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDTOFactory {

    @Autowired
    UserDAO userDAO;

    @Autowired
    LinkDTOFactory linkDTOFactory;

    public Book createModel(BookDTO dto) {
        Book book = new Book();

        if (dto != null) {
            book.setAuthor(dto.getAuthor());
            book.setSubcategories(dto.getCategories());
            book.setCountry(dto.getCountry());
            book.setDescription(dto.getDescription());
            book.setGanre(dto.getGanre());
            if(dto.getId() != null)
                book.setId(dto.getId());
            book.setLinks(linkDTOFactory.createModels(dto.getLinks()));
            book.setName(dto.getName());
            book.setNativeName(dto.getNativeName());
            book.setState(dto.getState());
            book.setYear(dto.getYear());
            book.setUser(userDAO.findUserById(dto.getUser()));
        }

        return book;
    }
}

package com.portaldc.web.distribution.book;

import com.portaldc.api.dto.distibution.book.BookDTO;
import com.portaldc.api.service.distribution.book.BookService;
import com.portaldc.web.AppController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookDistributionController extends AppController {

    @Autowired
    BookService bookService;

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/createBookDistribution",
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    public @ResponseBody Long createBookDistribution(@RequestBody BookDTO bookDTO) {
        bookDTO.setUser(getUserId());

        return bookService.saveBook(bookDTO);
    }
}

package com.portaldc.web.message;

import com.portaldc.impl.service.message.MessageServiceImpl;
import com.portaldc.web.AppController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MessageController extends AppController {

    @Autowired
    MessageServiceImpl messageService;

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "get_localization_message/{lang}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getLocalizedMessages(@PathVariable("lang") String lang) {

        return messageService.getLocalizationMessages(lang + ".json");

    }

}

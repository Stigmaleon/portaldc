package com.portaldc.impl.dto.distribution.audio;

import com.portaldc.api.dao.distribution.link.LinkDAO;
import com.portaldc.api.dao.user.UserDAO;
import com.portaldc.api.dto.distibution.audio.AudioDTO;
import com.portaldc.api.model.distributions.Audio;
import com.portaldc.impl.dto.distribution.link.LinkDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AudioDTOFactory {

    @Autowired
    UserDAO userDAO;

    @Autowired
    LinkDTOFactory linkDTOFactory;

    public Audio createModel(AudioDTO dto) {
        Audio audio = new Audio();

        if(dto != null) {
            audio.setTime(dto.getTime());
            audio.setSubcategories(dto.getCategories());
            audio.setCountry(dto.getCountry());
            audio.setDescription(dto.getDescription());
            audio.setGanre(dto.getGanre());
            if(dto.getId() != null)
                audio.setId(dto.getId());
            audio.setLinks(linkDTOFactory.createModels(dto.getLinks()));
            audio.setName(dto.getName());
            audio.setNativeName(dto.getNativeName());
            audio.setState(dto.getState());
            audio.setYear(dto.getYear());
            audio.setUser(userDAO.findUserById(dto.getUser()));
        }

        return audio;
    }
}

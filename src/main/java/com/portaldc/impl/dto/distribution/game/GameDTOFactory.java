package com.portaldc.impl.dto.distribution.game;

import com.portaldc.api.dao.user.UserDAO;
import com.portaldc.api.dto.distibution.game.GameDTO;
import com.portaldc.api.model.distributions.Game;
import com.portaldc.impl.dto.distribution.link.LinkDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameDTOFactory {

    @Autowired
    UserDAO userDAO;

    @Autowired
    LinkDTOFactory linkDTOFactory;

    public Game createModel(GameDTO dto) {
        Game game = new Game();

        if (dto != null) {
            game.setPublisher(dto.getPublisher());
            game.setDeveloper(dto.getDeveloper());
            game.setPublicationType(dto.getPublicationType());
            game.setLanguage(dto.getLanguage());
            game.setTranslate(dto.getTranslate());
            game.setSubcategories(dto.getCategories());
            game.setCountry(dto.getCountry());
            game.setDescription(dto.getDescription());
            game.setGanre(dto.getGanre());
            if (dto.getId() != null)
                game.setId(dto.getId());
            game.setLinks(linkDTOFactory.createModels(dto.getLinks()));
            game.setName(dto.getName());
            game.setNativeName(dto.getNativeName());
            game.setState(dto.getState());
            game.setYear(dto.getYear());
            game.setUser(userDAO.findUserById(dto.getUser()));
        }

        return game;
    }
}

package com.portaldc.impl.service.distribution.game;

import com.portaldc.api.dao.distribution.game.GameDAO;
import com.portaldc.api.data.DistributionState;
import com.portaldc.api.dto.distibution.game.GameDTO;
import com.portaldc.api.model.distributions.Game;
import com.portaldc.api.service.distribution.game.GameService;
import com.portaldc.api.service.distribution.link.LinkService;
import com.portaldc.impl.dto.distribution.game.GameDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameDAO gameDAO;

    @Autowired
    GameDTOFactory gameDTOFactory;

    @Autowired
    LinkService linkService;

    @Override
    public Long saveGame(GameDTO gameDTO) {
        Long savedGameId;
        Game game;

        if (gameDTO.getId() == null) {

            gameDTO.setState(DistributionState.NOT_MODERATED.getState());
            game = gameDTOFactory.createModel(gameDTO);
            savedGameId = gameDAO.saveDistribution(game);
            game.setId(savedGameId);

            linkService.saveLinks(gameDTO.getLinks(), game);

            return savedGameId;
        } else
            return -1L;
    }
}

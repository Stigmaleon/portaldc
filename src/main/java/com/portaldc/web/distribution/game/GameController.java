package com.portaldc.web.distribution.game;

import com.portaldc.api.dto.distibution.game.GameDTO;
import com.portaldc.api.service.distribution.game.GameService;
import com.portaldc.web.AppController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController extends AppController {

    @Autowired
    GameService gameService;

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/createGameDistribution",
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    public @ResponseBody Long createGameDistribution(@RequestBody GameDTO gameDTO) {

        gameDTO.setUser(getUserId());

        return gameService.saveGame(gameDTO);
    }
}

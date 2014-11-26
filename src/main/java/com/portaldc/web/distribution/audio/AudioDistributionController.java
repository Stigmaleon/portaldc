package com.portaldc.web.distribution.audio;

import com.portaldc.api.dto.distibution.audio.AudioDTO;
import com.portaldc.api.service.distribution.audio.AudioService;
import com.portaldc.web.AppController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AudioDistributionController extends AppController {

    @Autowired
    AudioService audioService;

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/createAudioDistribution",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json")
    public @ResponseBody Long createAudioDistribution(@RequestBody AudioDTO audioDTO) {

        audioDTO.setUser(getUserId());

        return audioService.saveAudio(audioDTO);
    }
}

package com.portaldc.impl.service.distribution.audio;

import com.portaldc.api.dao.distribution.audio.AudioDAO;
import com.portaldc.api.data.DistributionState;
import com.portaldc.api.dto.distibution.audio.AudioDTO;
import com.portaldc.api.model.distributions.Audio;
import com.portaldc.api.service.distribution.audio.AudioService;
import com.portaldc.api.service.distribution.link.LinkService;
import com.portaldc.impl.dto.distribution.audio.AudioDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudioServiceImpl implements AudioService {

    @Autowired
    AudioDAO audioDAO;

    @Autowired
    AudioDTOFactory audioDTOFactory;

    @Autowired
    LinkService linkService;

    @Override
    public Long saveAudio(AudioDTO audioDTO) {
        Long savedAudioId;
        Audio audio;

        if (audioDTO.getId() == null) {

            audioDTO.setState(DistributionState.NOT_MODERATED.getState());
            audio = audioDTOFactory.createModel(audioDTO);
            savedAudioId = audioDAO.saveDistribution(audio);
            audio.setId(savedAudioId);

            linkService.saveLinks(audioDTO.getLinks(), audio);

            return savedAudioId;
        } else
            return -1L;
    }
}

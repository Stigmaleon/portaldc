package com.portaldc.api.service.distribution.link;

import com.portaldc.api.dto.distibution.link.LinkDTO;
import com.portaldc.api.model.distributions.Distribution;

import java.util.List;

public interface LinkService {

    void saveLinks(LinkDTO linkDTO);

    void saveLinks(List<LinkDTO> linkDTOs, Distribution distribution);

}

package com.portaldc.api.service.distribution.link;

import com.portaldc.api.dto.distibution.link.LinkDTO;
import com.portaldc.api.model.distributions.link.Link;

import java.util.List;

public interface LinkService {

    public void saveLinks(LinkDTO linkDTO);

    public void saveLinks(List<LinkDTO> linkDTOs);

}

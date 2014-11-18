package com.portaldc.impl.service.distribution.link;

import com.portaldc.api.dao.distribution.link.LinkDAO;
import com.portaldc.api.dto.distibution.link.LinkDTO;
import com.portaldc.api.service.distribution.link.LinkService;
import com.portaldc.impl.dto.distribution.link.LinkDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    LinkDAO linkDAO;

    @Autowired
    LinkDTOFactory linkDTOFactory;

    @Override
    public void saveLinks(LinkDTO linkDTO) {
        linkDAO.saveLinks(linkDTOFactory.createModel(linkDTO));
    }

    @Override
    public void saveLinks(List<LinkDTO> linkDTOs) {
        linkDAO.saveLinks(linkDTOFactory.createModels(linkDTOs));
    }
}

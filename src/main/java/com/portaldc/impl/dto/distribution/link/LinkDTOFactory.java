package com.portaldc.impl.dto.distribution.link;

import com.portaldc.api.dto.distibution.link.LinkDTO;
import com.portaldc.api.model.distributions.link.Link;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinkDTOFactory {

    public Link createModel(LinkDTO linkDTO) {
        Link link = new Link();

        link.setPosition(linkDTO.getPosision());
        link.setName(linkDTO.getName());
        link.setMagnet(linkDTO.getMagnet());
        link.setDistribution(linkDTO.getDistribution());

        return link;
    }

    public List<Link> createModels(List<LinkDTO> linkDTOs) {
        List<Link> links = new ArrayList<Link>();

        for (LinkDTO linkDTO : linkDTOs) {
            links.add(createModel(linkDTO));
        }

        return links;
    }
}

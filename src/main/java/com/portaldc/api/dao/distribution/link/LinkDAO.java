package com.portaldc.api.dao.distribution.link;

import com.portaldc.api.model.distributions.link.Link;

import java.util.List;

public interface LinkDAO {

    public void saveLinks(Link link);

    public void saveLinks(List<Link> links);

}

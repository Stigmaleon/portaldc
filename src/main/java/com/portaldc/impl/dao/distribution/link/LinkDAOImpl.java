package com.portaldc.impl.dao.distribution.link;

import com.portaldc.api.dao.distribution.link.LinkDAO;
import com.portaldc.api.model.distributions.link.Link;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinkDAOImpl implements LinkDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveLinks(Link link) {
        sessionFactory.getCurrentSession().save(link);
    }

    @Override
    public void saveLinks(List<Link> links) {
        sessionFactory.getCurrentSession().save(links);
    }
}

package com.portaldc.impl.dao.distribution;

import com.portaldc.api.dao.distribution.DistributionDAO;
import com.portaldc.api.model.distributions.Distribution;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DistributionDAOImpl implements DistributionDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveDistribution(Distribution distribution) {

        sessionFactory.getCurrentSession().save(distribution);
    }
}

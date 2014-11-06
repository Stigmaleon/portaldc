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

    /**
     *
     * @param distribution distribution to save
     * @return id of saved distribution
     */
    @Override
    public Long saveDistribution(Distribution distribution) {

        return (Long)sessionFactory.getCurrentSession().save(distribution);
    }
}

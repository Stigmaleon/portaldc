package com.portaldc.impl.dao.role;

import com.portaldc.api.dao.role.RoleDAO;
import com.portaldc.api.model.role.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xdra on 12.08.14.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Role> getRoles() {
        return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
    }
}

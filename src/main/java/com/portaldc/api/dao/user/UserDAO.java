package com.portaldc.api.dao.user;

import com.portaldc.api.model.user.User;

public interface UserDAO {

    void addUser(User user);

    User findUserByLogin(String login);

    User findUserById(Long id);


}

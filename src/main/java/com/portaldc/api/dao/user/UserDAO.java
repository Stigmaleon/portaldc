package com.portaldc.api.dao.user;

import com.portaldc.api.model.user.User;

public interface UserDAO {

    public void addUser(User user);

    public User findUserByLogin(String login);

    public User findUserById(Long id);


}

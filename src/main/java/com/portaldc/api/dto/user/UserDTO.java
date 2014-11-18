package com.portaldc.api.dto.user;

import java.io.Serializable;
import java.util.List;

import com.portaldc.api.model.role.Role;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;
    private String password;
    private String email;
    private List<Role> roles;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}

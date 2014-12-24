package com.portaldc.api.dto.profile;

import com.portaldc.api.data.UserRole;

public class ProfileDTO {
    private String login;
    private String email;
    private UserRole role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

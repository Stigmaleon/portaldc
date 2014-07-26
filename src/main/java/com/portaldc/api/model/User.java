package com.portaldc.api.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(
                name = "currentUser",
                query = "from User u where u.userName = :login")
})
public class User extends Identificator implements UserDetails {

    @Column(name = "login")
    private String userName;
    @Column(name = "password")
    private String password;

    @Override
    public String getUsername() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}

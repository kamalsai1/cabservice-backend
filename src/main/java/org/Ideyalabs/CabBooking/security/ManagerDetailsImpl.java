package org.Ideyalabs.CabBooking.security;

import org.Ideyalabs.CabBooking.model.Manager;
import org.Ideyalabs.CabBooking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class ManagerDetailsImpl implements UserDetails {

    private final Manager manager;
    @Autowired
    public ManagerDetailsImpl(Manager manager)
    {
        this.manager=manager;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> set = new HashSet<>();
        set.add( new SimpleGrantedAuthority("ROLE_MANAGER"));
        return set;
    }

    @Override
    public String getPassword() {
        return manager.getManagerPassword();
    }

    @Override
    public String getUsername() {
        return manager.getManagerEmail();
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

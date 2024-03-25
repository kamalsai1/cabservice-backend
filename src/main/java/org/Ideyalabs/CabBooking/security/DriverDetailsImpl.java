package org.Ideyalabs.CabBooking.security;

import org.Ideyalabs.CabBooking.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class DriverDetailsImpl implements UserDetails {
    private final Driver driver;

    @Autowired
    public DriverDetailsImpl(Driver driver)
    {
        this.driver=driver;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> set = new HashSet<>();
        set.add( new SimpleGrantedAuthority("ROLE_DRIVER"));
        return set;
    }

    @Override
    public String getPassword() {
        return driver.getDriverPassword();
    }

     @Override
    public String getUsername() {
        return driver.getDriverEmail();
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

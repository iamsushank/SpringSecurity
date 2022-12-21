package com.exampl.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Builder
public class SecurityUser implements UserDetails {

    private final UserModel user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> role = new ArrayList<>();

        SimpleGrantedAuthority newRole = new SimpleGrantedAuthority(user.getRole().getRole());
        role.add(newRole);

        return role;
    }

    @Override
    public String getPassword() {

        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getMobileNumber();
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

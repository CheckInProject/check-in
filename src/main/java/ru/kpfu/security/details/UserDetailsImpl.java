package ru.kpfu.security.details;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kpfu.models.Role;
import ru.kpfu.models.User;

import java.util.Collection;

/**
 * 14.02.2018
 *
 * @author Robert Bagramov.
 */
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

    @Delegate
    private User user;
    private transient Collection<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return user.getLogin();
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
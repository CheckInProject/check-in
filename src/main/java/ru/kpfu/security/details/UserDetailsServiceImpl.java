package ru.kpfu.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.models.Role;
import ru.kpfu.models.User;
import ru.kpfu.repositories.RoleRepository;
import ru.kpfu.repositories.UserRepository;

import java.util.List;

/**
 * 14.02.2018
 *
 * @author Robert Bagramov.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String loginOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(loginOrEmail);
        List<Role> roles = roleRepository.findRoleByUserId(user.getId());

        return new UserDetailsImpl(user, roles);
    }
}
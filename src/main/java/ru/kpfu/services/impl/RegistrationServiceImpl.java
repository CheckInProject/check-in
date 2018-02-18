package ru.kpfu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.models.Role;
import ru.kpfu.models.User;
import ru.kpfu.repositories.RoleRepository;
import ru.kpfu.repositories.UserRepository;
import ru.kpfu.services.RegistrationService;

/**
 * 17.02.2018
 *
 * @author Robert Bagramov.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void create(User user, String password) {
        password = passwordEncoder.encode(password);
        user.setPassword(password);
        user = userRepository.save(user);

        roleRepository.save(Role.builder()
                .userId(user.getId())
                .role(Role.REGISTERED_USER.getAuthority())
                .build());

    }
}

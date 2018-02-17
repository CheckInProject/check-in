package ru.kpfu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.models.User;
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

    @Override
    public void create(User user, String password) {
        user.setPassword(password);
        userRepository.save(user);
    }
}

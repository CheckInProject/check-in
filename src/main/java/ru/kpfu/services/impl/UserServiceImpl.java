package ru.kpfu.services.impl;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.models.User;
import ru.kpfu.repositories.UserRepository;
import ru.kpfu.services.UserService;

/**
 * 18.02.2018
 *
 * @author Robert Bagramov.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User findByUsernameOrEmail(String loginOrEmail) {
        try {
            User user = userRepository.findByUsernameOrEmail(loginOrEmail);
            return user;
        } catch (Exception e) {
            throw e;
        }

    }

}

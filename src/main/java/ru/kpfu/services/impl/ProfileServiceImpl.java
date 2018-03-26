package ru.kpfu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.kpfu.models.User;
import ru.kpfu.repositories.UserRepository;
import ru.kpfu.services.ProfileService;

import java.util.List;

/**
 * 25.02.2018
 *
 * @author Robert Bagramov.
 */
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getMyProfile(Authentication authentication) {
        org.springframework.security.core.userdetails.User userDetails =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        String username = userDetails.getUsername();

        return userRepository.findByUsernameOrEmail(username);
    }

    @Override
    public User updateProfile(User user, Authentication authentication) {
        org.springframework.security.core.userdetails.User userDetails =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        String username = userDetails.getUsername();

        User dbUser = userRepository.findByUsernameOrEmail(username);

        if (user.getId() == dbUser.getId()) {
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public List<User> getSubscribes(Authentication authentication) {
        return null;
    }
}

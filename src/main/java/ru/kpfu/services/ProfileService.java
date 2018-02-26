package ru.kpfu.services;

import org.springframework.security.core.Authentication;
import ru.kpfu.models.User;

/**
 * 25.02.2018
 *
 * @author Robert Bagramov.
 */
public interface ProfileService {

    User getMyProfile(Authentication authentication);

    User updateProfile(User user, Authentication authentication);
}

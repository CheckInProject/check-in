package ru.kpfu.services;

import ru.kpfu.models.User;

/**
 * 18.02.2018
 *
 * @author Robert Bagramov.
 */
public interface UserService {
    User findByUsernameOrEmail(String loginOrEmail);

}

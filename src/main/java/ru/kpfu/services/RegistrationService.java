package ru.kpfu.services;

import ru.kpfu.models.User;

/**
 * 17.02.2018
 *
 * @author Robert Bagramov.
 */
public interface RegistrationService {
    void create(User user, String password);
}

package ru.kpfu.services;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.data.repository.CrudRepository;
import ru.kpfu.models.User;

/**
 * 18.02.2018
 *
 * @author Robert Bagramov.
 */
public interface UserService {
    User findByUsernameOrEmail(String loginOrEmail);
    User findById(int id) throws ObjectNotFoundException;
}

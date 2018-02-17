package ru.kpfu.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.models.User;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}

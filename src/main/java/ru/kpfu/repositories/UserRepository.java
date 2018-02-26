package ru.kpfu.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.models.User;

/**
 * 16.02.2018
 *
 * @author Robert Bagramov.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    //language=SQL
    @Query("SELECT u FROM checkin_user u WHERE u.login=:usernameOrEmail OR u.email=:usernameOrEmail")
    User findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

    User save(User user);
}

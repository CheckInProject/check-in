package ru.kpfu.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.models.Role;

import java.util.List;

/**
 * 18.02.2018
 *
 * @author Robert Bagramov.
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
    List<Role> findRoleByUserId(int id);
}

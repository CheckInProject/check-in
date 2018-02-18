package ru.kpfu.services;

import ru.kpfu.models.Role;

import java.util.List;

/**
 * 18.02.2018
 *
 * @author Robert Bagramov.
 */
public interface RoleService {
    List<Role> getRolesByUserId(int id);
}

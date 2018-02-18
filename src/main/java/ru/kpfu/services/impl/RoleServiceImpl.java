package ru.kpfu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.models.Role;
import ru.kpfu.repositories.RoleRepository;
import ru.kpfu.services.RoleService;

import java.util.List;

/**
 * 18.02.2018
 *
 * @author Robert Bagramov.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getRolesByUserId(int id) {
        return roleRepository.findRoleByUserId(id);
    }
}

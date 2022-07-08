package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;


    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role findRole(String role) {
        return roleDao.findRole(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleDao.deleteRole(role);
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}

package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();

    void saveRole(Role role);

    void getUserRoles(User user);

    Role applyRole(Role role);
}

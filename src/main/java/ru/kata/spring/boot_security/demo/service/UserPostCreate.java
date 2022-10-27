package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.annotation.PostConstruct;

@Component
public class UserPostCreate {

    private final UserService userService;
    private final RoleService roleService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserPostCreate(UserService userService, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostConstruct
    private void postConstruct() {
        roleService.saveRole(new Role(1L, "ADMIN"));
        roleService.saveRole(new Role(2L, "USER"));

//        userService.save(new User("admin1", "admin1", 22,
//                "admin1", "123", roleService.findAllRoles()));
    }
}

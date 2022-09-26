package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUserById(Long id);

    List<User> getAllUsers();

    List<Role> getAllRole();

    void addUser(User user);

    void deleteUserById(Long id);

    void updateUserById(User user);

    User getUserByName(String username);
}


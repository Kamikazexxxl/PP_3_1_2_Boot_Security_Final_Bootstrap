package ru.kata.spring.boot_security.demo.services;


import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user, String[] role);

    void deleteUser(int id);

    User getUser(int id);

    User getUserByName(String name);

    void editUser(User user);
}


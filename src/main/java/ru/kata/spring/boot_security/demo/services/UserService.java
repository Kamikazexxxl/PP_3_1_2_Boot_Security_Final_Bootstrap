package ru.kata.spring.boot_security.demo.services;


import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);

    User getUser(int id);

    User getUserByName(String name);

    void editUser(int id, String name, String surname, int age, String password);
}


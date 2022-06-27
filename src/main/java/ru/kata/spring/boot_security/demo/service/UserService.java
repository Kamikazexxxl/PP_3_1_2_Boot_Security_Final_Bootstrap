package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(String name, String surname, int age, String password);
    void deleteUser(int id);
    User getUser(int id);
    User getUserByName(String name);
    void editUser(int id, String name, String surname, int age, String password);
}

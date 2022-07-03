package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(int id);
    User getUser(int id);
    User getUserByName(String name);
    void editUser(int id, String name, String surname, int age, String password);
}
package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    void addUser(String name, String surname, int age, String password);
    void deleteUser(int id);
    User getUser(int id);
    User getUserByName(String name);
    void editUser(int id, String name, String surname, int age, String password);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
